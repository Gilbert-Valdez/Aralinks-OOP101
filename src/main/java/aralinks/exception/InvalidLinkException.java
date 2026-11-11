package aralinks.exception;

public class InvalidLinkException extends AralinksException{
    public InvalidLinkException(String link){ 
        super("Classroom link must start with http:// or https://"); 
    }
}
