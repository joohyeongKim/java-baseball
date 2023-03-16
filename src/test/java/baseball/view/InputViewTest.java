package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("InputView 클래스")
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

    @Test
    public void 숫자를_입력_받은_후_반환하라() throws Exception{
        //given
        String expectNumber = "123";
        String expectString = "숫자를 입력해주세요 : \n";
        InputStream inputStream = generateUserInput(expectNumber);
        System.setIn(inputStream);

        //when
        String actualNumber = inputView.inputBaseBallNumber();
        String actualString = PRINT.toString();

        //then
        assertEquals(expectNumber, actualNumber);
        assertEquals(expectString, actualString);
    }

}