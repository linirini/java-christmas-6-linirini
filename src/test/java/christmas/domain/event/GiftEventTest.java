package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiftEventTest {

    @DisplayName("할인 전 총주문 금액이 12만원 이상일 경우 증정품을 받을 수 있다.")
    @Test
    void 증정품_자격_여부() {
        int amount = 123000;
        assertThat(GiftEvent.canReceiveGift(amount)).isTrue();
    }

}
