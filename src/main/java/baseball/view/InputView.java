package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public enum InputView {
    INSTANCE;

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    public String inputBaseBallNumber() {
        System.out.println(INPUT_NUMBER);
        return Console.readLine();
    }
}
