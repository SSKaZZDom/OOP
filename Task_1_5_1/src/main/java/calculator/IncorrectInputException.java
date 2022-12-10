package calculator;

/**
 * This Exception will be thrown if user introduce incorrect string.
 */
public class IncorrectInputException extends Exception {
    public IncorrectInputException(String message) {
        super(message);
    }
}
