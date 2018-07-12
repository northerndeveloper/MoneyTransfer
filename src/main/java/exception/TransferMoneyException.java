package exception;

/**
 * Created by kopuz on 7/12/2018.
 */
public class TransferMoneyException extends Exception {


    public TransferMoneyException(String message) {
        super(message);
    }


    public TransferMoneyException(String message, Exception ex) {
        super(message + ex.getStackTrace());
    }

}
