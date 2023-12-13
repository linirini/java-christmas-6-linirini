package christmas.domain.menu;

import java.util.Arrays;

public enum MenuOption {

    MUSHROOM_SOUP("양송이 스프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000),
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_LIP("바베큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000),
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000),
    ZERO_COKE("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000),
    NONE("없음", 0);

    private final String name;
    private final int price;

    MenuOption(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuGroup isGroupOf() {
        return MenuGroup.findMenuGroup(this);
    }

    public static MenuOption hasMenu(String name) {
        return Arrays.stream(MenuOption.values()).filter(menuOption -> menuOption.name.equals(name))
                .findAny().orElse(NONE);
    }


}
