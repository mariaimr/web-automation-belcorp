package co.com.retobelcorp.certification.pruebatecnica.exceptions;

public class BelcorpError extends AssertionError  {

    public static final String MESSAGE_MENU_CATEGORIES_NOT_LOADED = "The menu categories could not be loaded";
    public static final String MESSAGE_FAILED_ADD_TO_CART = "Add to cart failed";
    public static final String MESSAGE_FAILED_DELETE_ITEMS = "Delete products failed";
    public static final String MESSAGE_FAILED_SET_ADDRESS = "Set address failed";

    public BelcorpError(String message, Throwable cause) {
        super(message, cause);
    }
}