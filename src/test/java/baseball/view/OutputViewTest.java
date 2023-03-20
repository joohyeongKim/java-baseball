package baseball.view;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OutputView 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OutputViewTest {

    private final ByteArrayOutputStream PRINT = new ByteArrayOutputStream();
    private final OutputView outputView = OutputView.INSTANCE;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(PRINT));
    }

    @AfterEach
    void reStore() {
        System.setOut(System.out);
        PRINT.reset();
    }

    @Nested
    class startBaseballGame_메서드는 {

        @Nested
        class 게임_시작_문구를 {
            private final String expect = "숫자 야구 게임을 시작합니다.\n";

            @Test
            public void 출력하라() {
                //given
                outputView.StartBaseballGame();

                //when
                String actual = PRINT.toString();

                //then
                assertEquals(expect, actual);
            }
        }

    }

}