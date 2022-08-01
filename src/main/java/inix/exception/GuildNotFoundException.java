package inix.exception;

public class GuildNotFoundException extends RuntimeException{
    public GuildNotFoundException(String guild) {
        super("Guild with name/id " + guild + " does not exist.");
    }
}
