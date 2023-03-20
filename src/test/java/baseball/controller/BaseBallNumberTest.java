package baseball.controller;

import static baseball.controller.BaseBallNumber.BASEBALL_NUMBER_LOWER_BOUND;
import static baseball.controller.BaseBallNumber.BASEBALL_NUMBER_UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseBallNumber 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseBallNumberTest {

    @Nested
    class valueOf_메서드는 {

        @Nested
        class 만약_1과_9사이_값을_입력받을_경우 {

            @Test
            public void BaseBallNumber_객체를_반환하라(){
                //given
                for (int i = BASEBALL_NUMBER_LOWER_BOUND; i < BASEBALL_NUMBER_UPPER_BOUND; i++) {
                    //then
                    assertThat(BaseBallNumber.valueOf(i)).isInstanceOf(BaseBallNumber.class);
                }
            }
        }

        @Nested
        class 만약_주어진_범위보다_더_높은_값을_입력받을_경우 {
            private final Integer given = BASEBALL_NUMBER_UPPER_BOUND + 1;

            @Test
            public void BaseBallNumberBoundException을_던져라() throws Exception{
                //then
                assertThatThrownBy(() -> BaseBallNumber.valueOf(given))
                        .isInstanceOf(BaseBallNumberBoundException.class);
            }
        }

        @Nested
        class 만약_주어진_범위보다_더_낮은_값을_입력받을_경우 {
            private final Integer given = BASEBALL_NUMBER_LOWER_BOUND - 1;

            @Test
            public void BaseBallNumberBoundException을_던져라() throws Exception{
                //then
                assertThatThrownBy(() -> BaseBallNumber.valueOf(given))
                        .isInstanceOf(BaseBallNumberBoundException.class);
            }
        }
    }

}