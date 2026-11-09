package aralinks.exception;

public class InvalidRatingException extends AralinksException {
    public InvalidRatingException(int rating){ 
        super("Rating must be 1 to 5, not "+ rating + ".");
    }
}