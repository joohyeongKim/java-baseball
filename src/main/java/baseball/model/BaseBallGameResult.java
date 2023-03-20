package baseball.model;

public class BaseBallGameResult {
    private final Integer strike;
    private final Integer ball;

    public BaseBallGameResult(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
