package subsystem.interbanksubsystem.utils;

import com.google.gson.JsonObject;
import entity.The;

public class JSonUtils {
    private static The getCard() {
        return The.getInstance();
    }

    /**
     * get a basic json object for transaction and for hash
     * @param command pay or refund
     * @param content note for transaction
     * @param amount amount of money
     * @return json object
     */
    private static JsonObject getJsonForTransaction(String command, String content, int amount) {
        The the = JSonUtils.getCard();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("command", command);
        jsonObject.addProperty("cardCode", the.getId());
        jsonObject.addProperty("owner", the.getOwner());
        jsonObject.addProperty("cvvCode", the.getCvv());
        jsonObject.addProperty("dateExpired", the.getDateExpire());
        jsonObject.addProperty("transactionContent", content);
        jsonObject.addProperty("amount", String.valueOf(amount));

        return jsonObject;
    }

    /**
     * get a hash of transaction for security
     * @param command pay or refund
     * @param content note for transaction
     * @param amount amount of money
     * @return string md5
     */
    private static String getHash(String command, String content, int amount) {
        JsonObject jsonForTransaction = JSonUtils.getJsonForTransaction(command, content, amount);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("secretKey", Config.SECRETKEY);
        jsonObject.add("transaction", jsonForTransaction);

        return Utils.md5(jsonObject.toString());
    }

    public static JsonObject getTransaction(String command, String content, int amount) {
        JsonObject jsonForTransaction = JSonUtils.getJsonForTransaction(command, content, amount);
        jsonForTransaction.addProperty("createdAt", Utils.getToday());

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("version", Config.API_VERSION);
        jsonObject.add("transaction", jsonForTransaction);
        jsonObject.addProperty("appCode", Config.APPCODE);
        jsonObject.addProperty("hashCode", JSonUtils.getHash(command, content, amount));
        return jsonObject;
    }

    public static JsonObject getReset() {
        The the = JSonUtils.getCard();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cardCode", the.getId());
        jsonObject.addProperty("owner", the.getOwner());
        jsonObject.addProperty("cvvCode", the.getCvv());
        jsonObject.addProperty("dateExpired", the.getDateExpire());
        return jsonObject;
    }
}
