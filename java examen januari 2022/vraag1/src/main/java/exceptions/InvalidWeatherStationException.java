package exceptions;

public class InvalidWeatherStationException extends RuntimeException {
    public InvalidWeatherStationException(String message) {
        super(message);
    }
}
