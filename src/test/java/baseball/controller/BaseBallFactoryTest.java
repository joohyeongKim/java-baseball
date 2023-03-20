package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BaseBallFactory 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
class BaseBallFactoryTest {
    private BaseBallFactory baseBallFactory = new BaseBallFactory();

    @Nested
    class generate_메서드는 {

        @Nested
        class 서로_다른_1부터_9사이_임의의_수_3개를_생성하여 {
            @Test
            public void 반환하라(){
                //given
                List<BaseBallNumber> result = baseBallFactory.generate();
                long expect = 3L;

                //when
                Set<BaseBallNumber> nonDuplicateBaseBalls = new HashSet<>(result);
                int actual = nonDuplicateBaseBalls.size();
                //then

                assertEquals(expect, actual);
            }
        }
    }

}