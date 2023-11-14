package christmas.view.viewenum;

public enum OutputEnum {

    ORDER_MENU_OUTPUT("<주문 메뉴>");

    private final String message;

    OutputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
