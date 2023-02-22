package techmaster.vn.homework.exception;

public class EntityNotFoundException extends RuntimeException{
    private String message;

    public EntityNotFoundException(final String message) {
        super(message);

    }
}
