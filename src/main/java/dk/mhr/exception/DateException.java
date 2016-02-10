package dk.mhr.exception;

/**
 * Created by Morten on 05-12-2015.
 *
 * Exception Class for invalid Dates.
 */
public class DateException extends RuntimeException {
    public DateException(String message) {
        super(message);
    }
}
