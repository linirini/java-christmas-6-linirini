package christmas.view.viewenum;

import static christmas.domain.menu.MenuOption.CHAMPAGNE;

public enum OutputEnum {

    ORDER_MENU_OUTPUT("<주문 메뉴>"),
    COUNT_UNIT("개"),
    ORDER_AMOUNT_OUTPUT("<할인 전 총주문 금액>"),
    MONEY_UNIT("원"),
    NONE("없음"),
    GIFT_MENU_OUTPUT("<증정 메뉴>"),
    CHRISTMAS_D_DAY_DISCOUNT_OUTPUT("크리스마스 디데이 할인:"),
    WEEK_DISCOUNT_OUTPUT("평일 할인: "),
    WEEKEND_DISCOUNT_OUTPUT("주말 할인: ");

    private final String message;

    OutputEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
