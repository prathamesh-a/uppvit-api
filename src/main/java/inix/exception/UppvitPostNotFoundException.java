package inix.exception;

public class UppvitPostNotFoundException extends RuntimeException{
    public UppvitPostNotFoundException(String post) {
        super("Post with name/id " + post + " does not exist.");
    }
}
