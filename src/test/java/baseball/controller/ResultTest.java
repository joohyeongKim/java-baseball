package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import baseball.CONSOLE;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("ResultTest 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ResultTest {

    @ParameterizedTest
    @CsvSource(value = {"123","457","369"})
    public void 결과_생성(String readLine){
        //given
        CONSOLE.setUp(readLine);
        List<Integer> hint = new Hint().buildHint();

        //when
        Result result = new Result(hint);

        String expect = "낫싱";
        String actual = result.buildResult();

        //then

        assertEquals(expect, actual);
    }

}

