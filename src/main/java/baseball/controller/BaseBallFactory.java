package baseball.controller;

import static java.util.stream.Collectors.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallFactory {
    private static final int BASEBALL_NUMBER_LOWER_BOUND = 1;
    private static final int BASEBALL_NUMBER_UPPER_BOUND = 9;
    private static final int BASEBALL_NUMBERS_SIZE = 3;

    public List<BaseBallNumber> generate() {
        List<Integer> baseballs = new ArrayList<>();

        while (baseballs.size() < BASEBALL_NUMBERS_SIZE) {
            addRandomNumber(baseballs);
        }

        return mapToBaseBallNumber(baseballs);
    }

    private void addRandomNumber(List<Integer> baseBalls) {
        int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_LOWER_BOUND, BASEBALL_NUMBER_UPPER_BOUND);
        if (!baseBalls.contains(randomNumber)) {
            baseBalls.add(randomNumber);
        }
    }

    private List<BaseBallNumber> mapToBaseBallNumber(List<Integer> baseBalls) {
        return baseBalls.stream()
                .map(BaseBallNumber::valueOf)
                .collect(toList());
    }
}
