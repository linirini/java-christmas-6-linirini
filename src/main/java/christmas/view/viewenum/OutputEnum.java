package christmas.view.viewenum;

public enum OutputEnum {

    ORDER_MENU_OUTPUT("<주문 메뉴>"),
    COUNT_UNIT("개"),
    ORDER_AMOUNT_OUTPUT("<할인 전 총주문 금액>"),
    MONEY_UNIT("원"),
    NONE("없음"),
    GIFT_MENU_OUTPUT("<증정 메뉴>"),
    BENEFIT_DETAIL_OUTPUT("<혜택 내역>"),
    CHRISTMAS_D_DAY_DISCOUNT_OUTPUT("크리스마스 디데이 할인: "),
    WEEK_DISCOUNT_OUTPUT("평일 할인: "),
    WEEKEND_DISCOUNT_OUTPUT("주말 할인: "),
    SPECIAL_DISCOUNT("특별 할인: "),
    GIFT_BENEFIT_OUTPUT("증정 이벤트: "),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    EXPECTED_PAY_AMOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>");

    private final String message;

    OutputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
