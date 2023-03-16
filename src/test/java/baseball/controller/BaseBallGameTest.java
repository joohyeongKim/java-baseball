package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    @Test
    public void 컴퓨터는_서로_다른_임의의_수_선택() throws Exception{
        //given
        BaseBallGame baseBallGame = new BaseBallGame();
        int expect = 3;

        //when
        baseBallGame.generate();
        List<Integer> actual = baseBallGame.getInstance();
        long count = actual.stream()
                .distinct()
                .count();

        //then
        assertEquals(expect, actual);
        assertEquals(expect, count);
    }

}