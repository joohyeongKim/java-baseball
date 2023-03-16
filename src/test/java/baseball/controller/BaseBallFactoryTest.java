package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("BaseBallFactory 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class BaseBallFactoryTest {

    @Test
    public void 서로_다른_임의의_수_3개를_생성하여_반환하라() throws Exception{
        //given
        List<BaseBall> baseBallNumbers = BaseBallFactory.generate();

        //when
        long expect = 3L;
        long actual = baseBallNumbers.stream()
                .distinct()
                .count();

        //then
        assertEquals(expect, actual);
    }

}