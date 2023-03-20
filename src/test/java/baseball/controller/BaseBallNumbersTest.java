package baseball.controller;



import static baseball.controller.BaseBallNumber.*;
import static org.assertj.core.api.Assertions.*;

import baseball.model.BaseBallGameResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseBallNumbers 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
class BaseBallNumbersTest {

    private BaseBallNumbers generate(int first, int second, int third) {
        return new BaseBallNumbers(List.of(
                valueOf(first),
                valueOf(second),
                valueOf(third)
        ));
    }

    private void assertBaseBallGameResult(BaseBallGameResult gameResult, Integer strike, Integer ball) {
        assertThat(gameResult.getStrike()).isEqualTo(strike);
        assertThat(gameResult.getBall()).isEqualTo(ball);
    }

    @Nested
    class 생성자는 {

        @Nested
        class 만약_범위를_벗어난_크기의_리스트를_입력받는_경우 {
            List<BaseBallNumber> given = List.of(valueOf(1));

            @Test
            public void BaseBallGameException을_던져라(){
                assertThatThrownBy(() -> new BaseBallNumbers(given))
                        .isInstanceOf(BaseBallGameException.class);
            }
        }

        @Nested
        class 만약_중복된_숫자가_들어간_리스트를_입력받는_경우 {

            @Test
            public void BaseBallGameException을_던져라(){
                assertThatThrownBy(() -> generate(7,7,7))
                        .isInstanceOf(BaseBallGameException.class);
            }
        }

        @Nested
        class play_메서드는 {
            private BaseBallNumbers computer = generate(1, 2, 3);

            @Nested
            class 만약_상대방이_3개의_숫자를_모두_맞춘_경우 {

                private BaseBallNumbers player = generate(1, 2, 3);

                @Test
                public void _3_strike_0_ball의_값을_가진_BaseBallGameResult를_반환하라() {
                    //given
                    BaseBallGameResult gameResult = computer.play(player);

                    //then
                    assertBaseBallGameResult(gameResult, 3, 0);
                }
            }

            @Nested
            class 만약_상대방이_2개의_숫자를_맞춘_경우 {

                private BaseBallNumbers player = generate(1,2,4);

                @Test
                public void _2_strike_0_ball_의_값을_가진_BaseBallGameResult를_반환하라(){
                    //given
                    BaseBallGameResult gameResult = computer.play(player);

                    //then
                    assertBaseBallGameResult(gameResult, 2, 0);
                }
            }

            @Nested
            class 만약_상대방이_1개의_숫자를_맞추고_1개는_위치가_다른_경우 {
                private BaseBallNumbers player = generate(1,3,6);

                @Test
                public void _1_strike_1_ball_의_값을_가진_baseBallGameResult_반환하라(){
                    //given
                    BaseBallGameResult gameResult = computer.play(player);

                    //then
                    assertBaseBallGameResult(gameResult, 1, 1);
                }
            }
            @Nested
            class 만약_상대방이_1개의_숫자를_맞추고_2개는_위치가_다른_경우 {
                private BaseBallNumbers player = generate(1,3,2);

                @Test
                public void _1_strike_2_ball_의_값을_가진_baseBallGameResult_반환하라(){
                    //given
                    BaseBallGameResult gameResult = computer.play(player);

                    //then
                    assertBaseBallGameResult(gameResult, 1, 2);
                }
            }
            @Nested
            class 만약_상대방이_맞춘_숫자가_하나도_없는_경우 {
                private BaseBallNumbers player = generate(4,5,6);

                @Test
                public void _0_strike_0_ball_의_값을_가진_baseBallGameResult_반환하라(){
                    //given
                    BaseBallGameResult gameResult = computer.play(player);

                    //then
                    assertBaseBallGameResult(gameResult, 0, 0);
                }
            }
            @Nested
            class 만약_상대방이_1개의_숫자만을_맞춘_경우 {
                private BaseBallNumbers player = generate(9,6,3);

                @Test
                public void _1_strike_0_ball_의_값을_가진_baseBallGameResult_반환하라(){
                    //given
                    BaseBallGameResult gameResult = computer.play(player);

                    //then
                    assertBaseBallGameResult(gameResult, 1, 0);
                }
            }
        }
    }

}