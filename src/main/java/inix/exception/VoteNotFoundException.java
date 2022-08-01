package inix.exception;

public class VoteNotFoundException extends RuntimeException{
    public VoteNotFoundException(String voteType) {
        super("Vote type " + voteType + " does not exist.");
    }
}
