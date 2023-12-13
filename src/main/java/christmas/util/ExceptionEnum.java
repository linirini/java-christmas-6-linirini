package christmas.util;

public enum ExceptionEnum {

    ORDERS_ONLY_BEVERAGE("음료만 주문할 수 없습니다. 다시 입력해 주세요."),
    ORDERS_COUNT_EXCESS("한번에 메뉴 최대 20개 주문 가능합니다. 다시 입력해 주세요.");

    private static final String ERROR = "[ERROR] ";
    private final String message;

    ExceptionEnum(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
