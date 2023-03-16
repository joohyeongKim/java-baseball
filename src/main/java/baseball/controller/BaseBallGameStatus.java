package baseball.controller;

import java.util.Arrays;

public enum BaseBallGameStatus {

    PLAY(1), STOP(2);

    private Integer statusCode;

    BaseBallGameStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static BaseBallGameStatus getEnum(Integer statusCode) {
        return Arrays.stream(values())
                .filter(status -> status.statusCode.equals(statusCode))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isGameContinues() {
        return this == PLAY;
    }
}
