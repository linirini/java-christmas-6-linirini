package christmas.domain.menu;

import java.util.Arrays;

public enum MenuOption {

    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000),
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000),
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000),
    ZERO_COKE("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000),
    NO_MENU("없음", 0);

    private final String viewName;

    private final int price;

    MenuOption(String viewName, int price) {
        this.viewName = viewName;
        this.price = price;
    }

    public String getViewName() {
        return this.viewName;
    }

    public int getPrice() {
        return this.price;
    }

    public static MenuOption findMenuOption(String viewName) {
        return Arrays.stream(MenuOption.values())
                .filter(menuOption -> menuOption.viewName.equals(viewName)).findAny()
                .orElse(NO_MENU);
    }

}
