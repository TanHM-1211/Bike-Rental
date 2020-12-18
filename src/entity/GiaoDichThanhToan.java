package entity;

public class GiaoDichThanhToan {
    private String errorCode;
    private The the;
    private String transactionId;
    private String transactionContent;
    private int amount;
    private String createdAt;
    public String paramsName = "id_giao_dich_thanh_toan, id_the, thoi_gian_tao, so_tien, noi_dung";

    public GiaoDichThanhToan(String errorCode, The the, String transactionId, String transactionContent, int amount, String createdAt) {
        this.errorCode = errorCode;
        this.the = the;
        this.transactionId = transactionId;
        this.transactionContent = transactionContent;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return ", '" + transactionId + '\'' +
                ", " + the.getOwner() +
                ", '" + createdAt + '\'' +
                ", " + amount +
                ", '" + transactionContent + '\'' +
                "";
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