package exceptions;

public class OrderException extends Exception {

    /**
     * @author Benat
     */

    private static final long serialVersionUID = 2L;

    public OrderException(final String message) {
        super(message);
    }

    public OrderException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
