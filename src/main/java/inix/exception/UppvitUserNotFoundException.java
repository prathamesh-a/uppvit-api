package inix.exception;

public class UppvitUserNotFoundException extends RuntimeException{
    public UppvitUserNotFoundException(String user) {
        super("User wid username/id " + user + " does not exist.");
    }
}
