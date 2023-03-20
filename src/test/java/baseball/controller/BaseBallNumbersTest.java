package baseball.controller;



import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseBallNumbers 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
class BaseBallNumbersTest {

    @Nested
    class 생성자는 {

        @Nested
        class 만약_범위를_벗어난_크기의_리스트를_입력받는_경우 {
            List<BaseBallNumber> given = List.of(BaseBallNumber.valueOf(1));

            @Test
            public void BaseBallGameException을_던져라(){
                Assertions.assertThatThrownBy(() -> new BaseBallNumbers(given))
                        .isInstanceOf(BaseBallGameException.class);
            }
        }

        @Nested
        class 만약_중복된_숫자가_들어간_리스트를_입력받는_경우 {
            List<BaseBallNumber> given = List.of(
                    BaseBallNumber.valueOf(1),
                    BaseBallNumber.valueOf(1),
                    BaseBallNumber.valueOf(1)
            );

            @Test
            public void BaseBallGameException을_던져라(){
                Assertions.assertThatThrownBy(() -> new BaseBallNumbers(given))
                        .isInstanceOf(BaseBallGameException.class);
            }
        }
    }

}