package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {

    private final InputView INPUT_VIEW;
    private final OutputView OUTPUT_VIEW;
    private BaseBallGameStatus gameStatus;

    public BaseBallGameController(InputView INPUT_VIEW, OutputView OUTPUT_VIEW) {
        this.INPUT_VIEW = INPUT_VIEW;
        this.OUTPUT_VIEW = OUTPUT_VIEW;
        this.gameStatus = BaseBallGameStatus.PLAY;
    }


    // 게임 실행
    public void run() {
        OUTPUT_VIEW.StartBaseballGame();

        while (gameStatus.isGameContinues()) {
            INPUT_VIEW.inputBaseBallNumber();
            gameStatus = INPUT_VIEW.inputGameStatus();
        }
    }
}
