package christmas.util;

public enum ExceptionEnum {

    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDERS("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MAXIMUM_ORDER_COUNT_EXCEEDED("메뉴는 한 번에 최대 20개까지 주문 가능합니다. 다시 입력해 주세요."),
    ORDERS_ONLY_BEVERAGE("음료만 주문할 수 없습니다. 다시 입력해 주세요.");

    private static final String NOTICE = "[ERROR] ";

    private String message;

    ExceptionEnum(String message) {
        this.message = NOTICE + message;
    }

    public String getMessage() {
        return this.message;
    }
}
