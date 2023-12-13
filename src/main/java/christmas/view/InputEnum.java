package christmas.view;

public enum InputEnum {

    RESERVATION_DATE_INPUT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDERS_INPUT("주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

    private final String message;

    InputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
