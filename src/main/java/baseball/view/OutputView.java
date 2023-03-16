package baseball.view;

public enum OutputView {

    INSTANCE;

    private final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void StartBaseballGame() {
        System.out.println(START_MESSAGE);
    }
}
