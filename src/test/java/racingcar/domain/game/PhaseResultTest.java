package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.car.CarMoveResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class PhaseResultTest {
    List<CarMoveResult> carMoveResults;

    @BeforeEach
    void setUp() {
        carMoveResults = new ArrayList<>();

        carMoveResults.add(new CarMoveResult("pobi", 1));
        carMoveResults.add(new CarMoveResult("crong", 0));
        carMoveResults.add(new CarMoveResult("horox", 1));
    }

    @DisplayName("한번 이동 시도후 결과 List를 반환한다.")
    @Test
    void getPhaseResult() {
        PhaseResult phaseResult = new PhaseResult(carMoveResults);

        assertThat(phaseResult.getRaceResult()).usingFieldByFieldElementComparator()
                .containsAll(carMoveResults);
    }

    @DisplayName("Phase의 현재 선두의 이름을 List의 형태로 반환한다.")
    @Test
    void findPhaseLeads() {
        PhaseResult phaseResult = new PhaseResult(carMoveResults);

        assertThat(phaseResult.findPhaseLeads()).contains("pobi", "horox");
    }

    @DisplayName("경기 기록이 없을때 우승자를 구하면 IllegalStatementException throw")
    @Test
    void whenNoPhaseFindLeadsThrowException() {
        PhaseResult phaseResult = new PhaseResult(new ArrayList<>());
        assertThatIllegalStateException()
                .isThrownBy(phaseResult::findPhaseLeads)
                .withMessage("경기 기록이 존재하지않습니다.");
    }
}