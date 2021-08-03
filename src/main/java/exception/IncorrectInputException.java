package exception;

public class IncorrectInputException extends Exception {
    public IncorrectInputException(String errorType, String errorPlace) {
        super(errorType + " : " + errorPlace);
    }
}
