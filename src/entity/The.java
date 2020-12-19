package entity;

import utils.Configs;

/*
    Chi doc
 */
public class The {
    private String id;
    private String owner;
    private String cvv;
    private String dateExpire;

    private int amount;

    private static The the = null;
    public The(String id, String owner, String cvv, String dateExpire) {
        this.id = id;
        this.owner = owner;
        this.cvv = cvv;
        this.dateExpire = dateExpire;
    }

    public static The getInstance() {
        if (the == null) {
            return new The(Configs.GROUP_NAME, Configs.OWNER, Configs.CVV_CODE, Configs.DATE_EXPIRED);
        } else {
            return the;
        }
    }

    @Override
    public String toString() {
        return "The{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", cvv='" + cvv + '\'' +
                ", dateExpire='" + dateExpire + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(String dateExpire) {
        this.dateExpire = dateExpire;
    }

    public boolean equals(String id) {
        return this.id.equals(id);
    }
}
