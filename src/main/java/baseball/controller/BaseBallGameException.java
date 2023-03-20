package baseball.controller;

public class BaseBallGameException extends RuntimeException {

    private static final String MESSAGE = "야구 게임 오류 발생";

    public BaseBallGameException() {
        super(MESSAGE);
    }
}
