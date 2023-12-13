package christmas.view;

public enum OutputEnum {

    EVENT_INTRODUCTION("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    BENEFITS_NOTICE_PREFIX("12월 "),
    BENEFITS_NOTICE_SUFFIX("일에 우테코 식당에서 받을 이벤트 미리 보기!"),
    ORDERS_TITLE("<주문 메뉴>"),
    TOTAL_ORDERS_PRICE_TITLE("<할인 전 총주문 금액>"),
    GIFT_TITLE("<증정 메뉴>"),
    BENEFITS_TITLE("<혜택 내역>"),
    TOTAL_BENEFITS_PRICE_TITLE("<총혜택 금액>"),
    ACTUAL_PAYMENT_PRICE_TITLE("<할인 후 예상 결제 금액>"),
    BADGE_TITLE("<12월 이벤트 배지>"),
    NONE("없음"),
    COUNT_UNIT("개"),
    MONEY_UNIT("원"),
    CHRISTMAS_D_DAY_DISCOUNT("크리스마스 디데이 할인: -"),
    WEEK_DISCOUNT("평일 할인: -"),
    WEEKEND_DISCOUNT("주말 할인: -"),
    SPECIAL_DISCOUNT("특별 할인: -"),
    GIFT_EVENT("증정 이벤트: -");

    private final String message;

    OutputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
