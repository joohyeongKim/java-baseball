package baseball.controller;

public enum BaseBallGameStatus {

    PLAY(1), STOP(2);

    private Integer statusCode;

    BaseBallGameStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
