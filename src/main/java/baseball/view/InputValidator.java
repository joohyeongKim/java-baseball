package baseball.view;

public class InputValidator {

    private static final int VALID_LENGTH = 3;
    private static final char START_RANGE = '1';
    private static final char END_RANGE = '9';

    private InputValidator() {
    }

    public static void validateBaseballNumber(String baseballNumber) {
        if (baseballNumber.length() != VALID_LENGTH ||
                distinctNumberLength(baseballNumber) != VALID_LENGTH) {
            throw new IllegalArgumentException();
        }

    }

    private static long distinctNumberLength(String baseballNumber) {
        return baseballNumber.chars()
                .filter(InputValidator::isValidNumberRange)
                .distinct()
                .count();
    }

    private static boolean isValidNumberRange(int number) {
        return number >= START_RANGE && number <= END_RANGE;
    }

}
