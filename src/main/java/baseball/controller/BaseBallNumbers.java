package baseball.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumbers {
    private static final int VALID_BASEBALL_COUNT = 3;

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
}
