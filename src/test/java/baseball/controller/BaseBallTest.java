package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseBallTest {

    @Test
    public void 값을_반환하라(){
        int expect = 1;
        final int ONE = 1;
        //given
        BaseBall baseBall = new BaseBall(ONE);
        Integer actual = baseBall.getNumber();

        //then
        assertEquals(expect, actual);
    }

}