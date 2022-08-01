package inix.model;

import inix.exception.UppvitException;

import java.util.Arrays;

public enum VoteType {
    UPVOTE(1), DOWNVOTE(-1);

    private int direction;

    VoteType(int direction) {}

    public static VoteType lookup (Integer direction) {
        return Arrays.stream(VoteType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new UppvitException("Vote Not Found"));
    }

    private Object getDirection() {
        return direction;
    }
}
