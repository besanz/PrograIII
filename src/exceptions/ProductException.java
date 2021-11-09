package exceptions;

public class ProductException extends Exception {

    /**
     * @author Jon Ander
     */

    private static final long serialVersionUID = 3L;

    public ProductException(final String message) {
        super(message);
    }

    public ProductException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
