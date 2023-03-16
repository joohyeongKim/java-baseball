package baseball.view;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("OutputView 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OutputViewTest {

    private final ByteArrayOutputStream PRINT = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(PRINT));
    }

    @AfterEach
    void reStore() {
        System.setOut(System.out);
        PRINT.reset();
    }


    @Test
    public void 게임_시작_문구를_화면에_출력하라() throws Exception{
        //given
        OutputView.StartBaseballGame();
        final String EXPECT = "숫자 야구 게임을 시작합니다.\n";
        String actual = PRINT.toString();

        //then
        assertEquals(EXPECT, actual);
    }

}