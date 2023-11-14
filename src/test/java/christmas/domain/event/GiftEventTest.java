package christmas.domain.event;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiftEventTest {

    private GiftEvent giftEvent;

    @BeforeEach
    void init() {
        giftEvent = new GiftEvent();
    }

    @DisplayName("할인 전 총주문 금액이 12만원 이상일 경우 증정품을 받을 수 있다.")
    @Test
    void 증정품_자격_여부_O() {
        int amount = 123000;
        assertThat(giftEvent.receiveGift(amount)).hasSize(1).contains(entry("샴페인", 1));
    }

    @DisplayName("할인 전 총주문 금액이 12만원 이하일 경우 증정품을 받을 수 없다.")
    @Test
    void 증정품_자격_여부_X() {
        int amount = 12300;
        assertThat(giftEvent.receiveGift(amount)).isEmpty();
    }

}
