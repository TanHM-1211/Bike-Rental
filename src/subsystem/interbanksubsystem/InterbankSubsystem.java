package subsystem.interbanksubsystem;


import entity.GiaoDichThanhToan;
import subsystem.interbanksubsystem.interbank.InterbankSubsystemController;
import entity.The;


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
        GiaoDichThanhToan giaoDichThanhToan = ctrl.pay(the, amount, contents);
        return giaoDichThanhToan;
    }

    public GiaoDichThanhToan refund(The the, int amount, String contents) {
        GiaoDichThanhToan giaoDichThanhToan = ctrl.refund(the, amount, contents);
        return giaoDichThanhToan;
    }
}
