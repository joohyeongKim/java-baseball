package baseball.controller;

import baseball.view.OutputView;

public class BaseBallGameController {

    private static final OutputView outputView = OutputView.INSTANCE;

    private static BaseBallGameStatus gameStatus;

    public static void run() {
        initializeGame();
        while (gameStatus.isPlay()) {
            changeGameStatusToStop();
        }

    }

    // 게임을 초기화하라
    private static void initializeGame() {
        outputView.StartBaseballGame();
        changeGameStatusToPlay();
    }

    // 게임 상태를 진행으로 변경하라
    private static void changeGameStatusToPlay() {
        gameStatus = BaseBallGameStatus.PLAY;

    }

    // 게임 상태를 종료로 변경하라
    private static void changeGameStatusToStop() {
        gameStatus = BaseBallGameStatus.STOP;
    }
}
