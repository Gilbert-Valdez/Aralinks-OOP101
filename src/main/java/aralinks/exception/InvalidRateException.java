package aralinks.exception; 

public class InvalidRateException extends AralinksException{ 
    public InvalidRateException(String rate){ 
        super("Rate must be between 0PHP and 5000PHP, not PHP " + rate +"." );
    }
}