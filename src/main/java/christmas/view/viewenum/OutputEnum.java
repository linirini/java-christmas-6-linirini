package christmas.view.viewenum;

import static christmas.domain.menu.MenuOption.CHAMPAGNE;

public enum OutputEnum {

    ORDER_MENU_OUTPUT("<주문 메뉴>"),
    COUNT_UNIT("개"),
    ORDER_AMOUNT_OUTPUT("<할인 전 총주문 금액>"),
    MONEY_UNIT("원"),
    NONE("없음"),
    GIFT_MENU_OUTPUT("<증정 메뉴>");

    private final String message;

    OutputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
