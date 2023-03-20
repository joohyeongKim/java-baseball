package baseball.controller;

import java.util.HashMap;

public class BaseBallNumber {
    private final static int BASEBALL_NUMBER_LOWER_BOUND = 1;
    private final static int BASEBALL_NUMBER_UPPER_BOUND = 9;
    private static final HashMap<Integer, BaseBallNumber> CACHE = new HashMap<>();

    static {
        for (int i = BASEBALL_NUMBER_LOWER_BOUND; i <= BASEBALL_NUMBER_UPPER_BOUND; i++) {
            CACHE.putIfAbsent(i, new BaseBallNumber(i));
        }
    }

    private Integer number;

    private BaseBallNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    public static BaseBallNumber valueOf(Integer number) {
        validate(number);
        return CACHE.get(number);
    }
    private static void validate(Integer number) {
        if ( number < BASEBALL_NUMBER_LOWER_BOUND || number > BASEBALL_NUMBER_UPPER_BOUND ) {
            throw new BaseBallNumberBoundException();
        }
    }
}
