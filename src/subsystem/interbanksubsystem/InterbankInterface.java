package subsystem.interbanksubsystem;

import entity.GiaoDichThanhToan;
import entity.The;


public interface InterbankInterface {
    /**
     * Pay order, and then return the payment transaction
     *
     * @param the     - the credit card used for payment
     * @param amount   - the amount to pay
     * @param content - the transaction contents
     * @return {@link GiaoDichThanhToan PaymentTransaction} - if the
     *         payment is successful
     */
    public abstract GiaoDichThanhToan pay(The the, int amount, String content);

    /**
     * Refund, and then return the payment transaction
     *
     * @param the     - the credit card which would be refunded to
     * @param amount   - the amount to refund
     * @param content - the transaction contents
     * @return {@link GiaoDichThanhToan PaymentTransaction} - if the
     *         payment is successful
     */
    public abstract GiaoDichThanhToan refund(The the, int amount, String content);
}
