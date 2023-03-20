package baseball.controller;

import baseball.model.BaseBallGameResult;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class BaseBallNumbers {
    private static final int VALID_BASEBALL_COUNT = 3;
    private static final int BASEBALL_NUMBERS_START_INDEX = 0;
    private static final int BASEBALL_NUMBERS_END_INDEX = 2;

    List<BaseBallNumber> baseBallNumbers;

    public BaseBallNumbers(List<BaseBallNumber> baseBallNumbers) {
        validateSize(baseBallNumbers);
        validateDuplicate(baseBallNumbers);
        this.baseBallNumbers = baseBallNumbers;
    }

    private void validateSize(List<BaseBallNumber> baseBallNumbers) {
        if (baseBallNumbers.size() != VALID_BASEBALL_COUNT) {
            throw new BaseBallGameException();
        }
    }

    private void validateDuplicate(List<BaseBallNumber> baseBallNumbers) {
        Set<BaseBallNumber> nonDuplicateBaseBalls = new HashSet<>(baseBallNumbers);
        if (nonDuplicateBaseBalls.size() != VALID_BASEBALL_COUNT) {
            throw new BaseBallGameException();
        }
    }

    public BaseBallGameResult play(BaseBallNumbers opponent) {
        int strike = calculateStrike(opponent);
        int ball = calculateBall(opponent, strike);

        return new BaseBallGameResult(strike, ball);
    }

    private int calculateStrike(BaseBallNumbers opponent) {
        return (int) IntStream.rangeClosed(BASEBALL_NUMBERS_START_INDEX, BASEBALL_NUMBERS_END_INDEX)
                .filter(isStrike(opponent))
                .count();
    }

    private IntPredicate isStrike(BaseBallNumbers opponent) {
        return i -> opponent.baseBallNumbers
                .get(i)
                .equals(this.baseBallNumbers.get(i));
    }

    private int calculateBall(BaseBallNumbers opponent, int strike) {
        return (int) opponent.baseBallNumbers.stream()
                .filter(this::isBall)
                .count() - strike;
    }

    private boolean isBall(BaseBallNumber baseBallNumber) {
        return this.baseBallNumbers.contains(baseBallNumber);
    }
}
