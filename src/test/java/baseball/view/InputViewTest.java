package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import baseball.controller.BaseBallGameStatus;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("InputView 클래스")
@SuppressWarnings({"InnerClassMayBestaticc", "NonAsciiCharacters"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class InputViewTest {

    private final ByteArrayOutputStream PRINT = new ByteArrayOutputStream();
    private final InputView inputView = InputView.INSTANCE;

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(PRINT));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
        PRINT.reset();
    }

    @Nested
    class inputBaseBallNumber는_숫자_입력_문구를_출력 {
        private String console = "숫자를 입력해주세요 : \n";

        @Nested
        class 만약_숫자를_입력받으면 {
            final String GIVEN = "123";
            private InputStream inputStream = generateUserInput(GIVEN);

            @Test
            public void 그대로_리턴하라() {
                //given
                System.setIn(inputStream);
                String actual = inputView.inputBaseBallNumber();

                //when

                //then
                assertEquals(PRINT.toString(), console);
                assertEquals(GIVEN, actual);
            }
        }

        @Nested
        class 만약_허용된_입력값이_아닌_경우 {
            private InputStream inputStream = generateUserInput("999");

            @Test
            public void 예외_처리(){
                //given
                System.setIn(inputStream);

                //then
                Assertions.assertThatThrownBy(inputView::inputBaseBallNumber)
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        class inputGameStatus는_게임_재시작_여부_문구_출력 {
            private String console = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

            @Nested
            class 만약_1을_입력받는_경우 {
                String GIVEN = "1";
                private InputStream given = generateUserInput(GIVEN);

                @Test
                public void BaseBallGameStatus_Play를_리턴() throws Exception{
                    //given
                    System.setIn(given);
                    BaseBallGameStatus actualStatus = BaseBallGameStatus.PLAY;

                    //when
                    BaseBallGameStatus baseBallGameStatus = inputView.inputGameStatus();

                    //then
                    assertEquals(PRINT.toString(), console);
                    assertEquals(baseBallGameStatus, actualStatus);
                }
            }

            @Nested
            class 만약_2를_입력받는_경우 {
                private String GIVEN = "2";
                private InputStream inputStream = generateUserInput(GIVEN);

                @Test
                public void BaseBallGameStatus_STOP을_리턴(){
                    //given
                    System.setIn(inputStream);

                    //when
                    BaseBallGameStatus baseBallGameStatus = inputView.inputGameStatus();
                    BaseBallGameStatus actualStatus = BaseBallGameStatus.STOP;

                    //then
                    assertEquals(PRINT.toString(), console);
                    assertEquals(baseBallGameStatus, actualStatus);
                }
            }
        }

    }


}