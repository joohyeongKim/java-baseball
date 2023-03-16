package baseball.controller;

import static java.util.stream.Collectors.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallFactory {
    private static final int START = 1;
    private static final int END = 9;
    private static final int RANGE = 3;

    // 서로 다른 임의의 수 3개를 생성하라
    public static List<BaseBall> generate() {
        List<Integer> baseballs = Randoms.pickUniqueNumbersInRange(START, END, RANGE);

        return baseballs.stream()
                .map(BaseBall::new)
                .collect(toList());
    }

}
