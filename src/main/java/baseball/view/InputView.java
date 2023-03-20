package baseball.view;

import baseball.controller.BaseBallGameStatus;
import camp.nextstep.edu.missionutils.Console;

public enum InputView {
    INSTANCE;

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String INPUT_GAME_STATUS = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // 입력값을 출력하라
    public String inputBaseBallNumber() {
        System.out.print(INPUT_NUMBER);
        String baseBallNumber = Console.readLine();

        InputValidator.validateBaseballNumber(baseBallNumber);

        return baseBallNumber;
    }

    // 게임 재시작/종료 여부를 입력하라
    public BaseBallGameStatus inputGameStatus() {
        System.out.println(INPUT_GAME_STATUS);
        String gameStatus = Console.readLine();

        InputValidator.validateGameStatus(gameStatus);

        return BaseBallGameStatus.getEnum(Integer.valueOf(gameStatus));
    }
}
