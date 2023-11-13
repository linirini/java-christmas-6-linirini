package christmas.view.viewenum;

public enum InputEnum {

    VISITING_DATE_INPUT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

    private final String message;

    InputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
