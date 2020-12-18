package subsystem.interbanksubsystem;


import entity.GiaoDichThanhToan;
import subsystem.interbanksubsystem.interbank.InterbankSubsystemController;
import entity.The;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 *
 * @author sandl
 *
 */

public class InterbankSubsystem implements InterbankInterface {

    /**
     * Represent the controller of the subsystem
     */
    private InterbankSubsystemController ctrl;

    /**
     * Initializes a newly created {@code InterbankSubsystem} object so that it
     * represents an Interbank subsystem.
     */
    public InterbankSubsystem() {
        String str = new String();
        this.ctrl = new InterbankSubsystemController();
    }

    public GiaoDichThanhToan pay(The the, int amount, String contents) {
        GiaoDichThanhToan transaction = ctrl.pay(the, amount, contents);
        return transaction;
    }

    public GiaoDichThanhToan refund(The the, int amount, String contents) {
        GiaoDichThanhToan transaction = ctrl.refund(the, amount, contents);
        return transaction;
    }
}
