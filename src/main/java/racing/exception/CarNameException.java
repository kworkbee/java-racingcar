package racing.exception;

public class CarNameException extends RuntimeException {

    public CarNameException(String name){
        super(name);
    }
}