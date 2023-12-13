package christmas.domain;

import christmas.domain.menu.MenuOption;

public enum Gift {

    ;

    public final MenuOption menu;
    public final int count;

    Gift(MenuOption menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public static boolean receiveGift(int maount){
        return false;
    }
}
