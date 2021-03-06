package exceptions;

public class ShopException extends Exception {

    /**
     * @author Jon Ander
     */
    
    private static final long serialVersionUID = 4L;

    public ShopException(final String message) {
        super(message);
    }

    public ShopException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
