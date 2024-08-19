package exceptions;

public class DatumTijdInToekomstException extends RuntimeException {
    public DatumTijdInToekomstException(String message) {
        super(message);
    }
}