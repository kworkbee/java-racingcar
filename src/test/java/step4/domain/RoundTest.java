package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RoundTest {

    @DisplayName("시도할 회수를 0이하로 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void roundCount_exception(int roundCount) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Round.from((roundCount));
        });
    }

    @DisplayName("시도할 회수가 0보다 클 경우 이동이 가능한지 확안한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true"})
    void isMovable(int roundCount, boolean expected) {
        // given
        Round round = Round.from(roundCount);
        // when
        boolean isMovable = round.isMovable();
        // then
        assertThat(isMovable).isEqualTo(expected);
    }
}