package baseball;


import baseball.controller.BaseBallGameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseBallGameController baseBallGameController = new BaseBallGameController(
                InputView.INSTANCE,
                OutputView.INSTANCE
        );
        baseBallGameController.run();

    }
}
