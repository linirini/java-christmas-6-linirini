package christmas.domain.event.gift;

import static christmas.domain.event.gift.Gift.GIFT;
import static christmas.domain.event.gift.Gift.NO_GIFT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiftTest {

    @DisplayName("할인 전 총주문 금액이 12만원 이상일 경우 증정품을 받을 수 있다.")
    @Test
    void 증정품_자격_여부_O() {
        int amount = 123000;
        assertThat(Gift.receiveGift(amount)).isEqualTo(GIFT);
    }

    @DisplayName("할인 전 총주문 금액이 12만원 이하일 경우 증정품을 받을 수 없다.")
    @Test
    void 증정품_자격_여부_X() {
        int amount = 12300;
        assertThat(Gift.receiveGift(amount)).isEqualTo(NO_GIFT);
    }

}
