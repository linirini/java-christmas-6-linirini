package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventPlannerTest {

    private final static int MINIMUM = 10000;

    private EventPlanner eventPlanner;

    @BeforeEach
    void init() {
        eventPlanner = new EventPlanner();
    }

    @DisplayName("이벤트 적용 가능한 최소 금액을 충족하는지 판단한다.")
    @ParameterizedTest
    @ValueSource(ints = {10000, 5000})
    void 이벤트_적용_가능_여부(int amount) {
        assertThat(eventPlanner.isMinimumAmountForEventMet(amount)).isEqualTo(expected(amount));
    }

    private boolean expected(int amount) {
        return amount >= MINIMUM;
    }

}