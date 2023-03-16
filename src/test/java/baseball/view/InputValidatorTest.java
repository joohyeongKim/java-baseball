package baseball.view;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @Nested
    class 만약_1과_9_사이_중복되지_않는_3자리_수_입력받으면 {
        private final String GIVEN_VALID_INPUT_1 = "123";
        private final String GIVEN_VALID_INPUT_2 = "456";
        private final String GIVEN_VALID_INPUT_3 = "789";

        @Test
        void 정상_처리() {
            InputValidator.validateBaseballNumber(GIVEN_VALID_INPUT_1);
            InputValidator.validateBaseballNumber(GIVEN_VALID_INPUT_2);
            InputValidator.validateBaseballNumber(GIVEN_VALID_INPUT_3);
        }
    }

    @Nested
    class 만약_범위를_벗어난_자리수_입력받으면 {
        private final String GIVEN_TWO_DIGITS = "12";
        private final String GIVEN_FOUR_DIGITS = "1234";

        @Test
        void 두_자리수_예외_처리() {
            assertThatThrownBy(() -> InputValidator.validateBaseballNumber(GIVEN_TWO_DIGITS))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 네_자리수_예외_처리() {
            assertThatThrownBy(() -> InputValidator.validateBaseballNumber(GIVEN_FOUR_DIGITS))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 중복_값이_있는_3자리_수_입력 {
        private final String GIVEN_DUPLICATE = "111";

        @Test
        void 중복_예외_처리() {
            assertThatThrownBy(() -> InputValidator.validateBaseballNumber(GIVEN_DUPLICATE))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class 만약_1이나_2가_아닌_다른_값을_입력받는_경우 {
        private final String GIVEN = "3";

        @Test
        public void 에외_처리(){
            assertThatThrownBy(() -> InputValidator.validateGameStatus(GIVEN))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}