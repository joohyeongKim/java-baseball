package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseBallGame {

    private List<Integer> baseball;

    // 서로 다른 3개의 수를 생성하라
    public void generate() {
        List<Integer> computer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        this.baseball = computer;
    }

    public List<Integer> getInstance() {
        return baseball;
    }
}
