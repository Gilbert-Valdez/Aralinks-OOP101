package aralinks.exception; 

public class InvalidRateException extends AralinksException{ 
    public InvalidRateException(double rate){ 
        super("Rate must be between 0PHP and 5000PHP, not PHP " + rate +"." );
    }
}