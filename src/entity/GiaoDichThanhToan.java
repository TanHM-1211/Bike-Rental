package entity;

/*
    Doc va ghi
 */

public class GiaoDichThanhToan{
    private String errorCode;
    private int id=-1;
    private The the;
    private String transactionId;
    private String transactionContent;
    private int amount;
    private String createdAt;
    public static String paramsName = "(id_giao_dich_thanh_toan, id_the, thoi_gian_tao, so_tien, noi_dung)";
    public static String name = "giao_dich_thanh_toan";

    public GiaoDichThanhToan(String errorCode, The the, String transactionId, String transactionContent, int amount, String createdAt) {
        this.errorCode = errorCode;
        this.the = the;
        this.transactionId = transactionId;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public GiaoDichThanhToan(int id, The the, String createdAt, int amount, String transactionContent) {
        this.id = id;
        this.the = the;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "GiaoDichThanhToan{" +
                "errorCode='" + errorCode + '\'' +
                ", id=" + id +
                ", the=" + the +
                ", transactionId='" + transactionId + '\'' +
                ", transactionContent='" + transactionContent + '\'' +
                ", amount=" + amount +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

    public String toSQLString() {
        return "( '" + id + '\'' +
                ", '" + the.getId() + '\'' +
                ", '" + createdAt + '\'' +
                ", " + amount +
                ", '" + transactionContent + '\'' +
                ")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public The getThe() {
        return the;
    }

    public void setThe(The the) {
        this.the = the;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public The getCard() {
        return the;
    }

    public void setCard(The the) {
        this.the = the;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}