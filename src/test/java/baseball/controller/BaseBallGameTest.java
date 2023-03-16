package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("BaseBallGame 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class BaseBallGameTest {

    @Test
    public void 컴퓨터는_서로_다른_임의의_수_선택() throws Exception{
        //given
        BaseBallGame baseBallGame = new BaseBallGame();
        int expect = 3;

        //when
        baseBallGame.generate();
        List<Integer> computer = baseBallGame.getInstance();
        int actual = computer.size();
        long count = computer.stream()
                .distinct()
                .count();

        //then
        assertEquals(expect, actual);
        assertEquals(expect, count);
    }

}