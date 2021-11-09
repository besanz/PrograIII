package exceptions;

public class BasketException extends Exception {

    /**
     * @author Benat
     */

    private static final long serialVersionUID = 1L;

    public BasketException(final String message) {
        super(message);
    }

    public BasketException(final String message, final Throwable throwable) {
        super(message, throwable);
    }



}
