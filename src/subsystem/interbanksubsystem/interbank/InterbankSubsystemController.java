package subsystem.interbanksubsystem.interbank;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.*;
import common.exception.PaymentException;
import subsystem.interbanksubsystem.utils.Config;
import subsystem.interbanksubsystem.utils.JSonUtils;
import subsystem.interbanksubsystem.utils.Utils;
import common.exception.*;

public class InterbankSubsystemController {
    private static InterbankBoundary interbankBoundary = new InterbankBoundary();

    /**
     * query and get a Payment Transaction
     * @param the
     * @param amount
     * @param contents
     * @return
     */
    public GiaoDichThanhToan pay(The the, int amount, String contents) throws PaymentException {
        JsonObject jsonObject = JSonUtils.getTransaction(Config.payComment, contents, amount);

        String responseText = interbankBoundary.query(Config.baseUrl + Config.transactionUrl, jsonObject.toString());
        System.out.println(responseText);
        return extractPaymentTransaction(responseText);
    }

    /**
     * query and refund transaction
     * @param the
     * @param amount
     * @param contents
     * @return
     */
    public GiaoDichThanhToan refund(The the, int amount, String contents) throws PaymentException {
        JsonObject jsonObject = JSonUtils.getTransaction(Config.refundComment, contents, amount);

        String respondText = interbankBoundary.query(Config.baseUrl + Config.transactionUrl, jsonObject.toString());
        return extractPaymentTransaction(respondText);
    }

    private GiaoDichThanhToan extractPaymentTransaction(String respond) throws PaymentException {
        The the = The.getInstance();
        JsonObject respondJson = new JsonParser().parse(respond).getAsJsonObject();
        String errCode = respondJson.get("errorCode").getAsString();

        switch (errCode) {
            case "00":
                break;
            case "01":
                throw new InvalidCardException();
            case "02":
                throw new NotEnoughBalanceException();
            case "03":
                throw new InternalServerErrorException();
            case "04":
                throw new SuspiciousTransactionException();
            case "05":
                throw new NotEnoughTransactionInfoException();
            case "06":
                throw new InvalidVersionException();
            case "07":
                throw new InvalidTransactionAmountException();
            default:
                throw new UnrecognizedException();
        }

        JsonObject transactionJson = respondJson.getAsJsonObject("transaction");

        if (the.equals(transactionJson.get("cardCode").getAsString())) {
            Utils.LOGGER.warning("ID Card not match with respond card");
        }
        the.setAmount(1000);

        String transactionId = transactionJson.get("transactionId").getAsString();
        String transactionContent = transactionJson.get("transactionContent").getAsString();
        int amount = transactionJson.get("amount").getAsInt();
        if (transactionJson.get("command").getAsString().equals("pay")) amount = -amount;
        String createdAt = transactionJson.get("createdAt").getAsString();
        return new GiaoDichThanhToan(errCode, the, transactionId, transactionContent, amount, createdAt);
    }

    public String reset() {
        JsonObject jsonObject = new JsonObject();
        The the = The.getInstance();

        jsonObject.addProperty("cardCode", the.getId());
        jsonObject.addProperty("owner", the.getOwner());
        jsonObject.addProperty("cvvCode", the.getCvv());
        jsonObject.addProperty("dateExpired", the.getDateExpire());

        String respondText = interbankBoundary.query(Config.baseUrl + Config.resetUrl, jsonObject.toString());
        return respondText;
    }
    public static void main(String[] args) {
        InterbankSubsystemController interbankSubsystemController = new InterbankSubsystemController();
//        System.out.println(interbankSubsystemController.reset());
        System.out.println(interbankSubsystemController.pay(The.getInstance(), 15000, "San rut tien"));
    }
}
