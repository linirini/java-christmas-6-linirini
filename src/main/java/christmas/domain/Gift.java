package christmas.domain;

import static christmas.domain.menu.MenuOption.CHAMPAGNE;

import christmas.domain.menu.MenuOption;

public enum Gift {

    GIFT(CHAMPAGNE, 1, 120000);

    public final MenuOption menu;
    public final int count;
    public final int minimumOrderPrice;

    Gift(MenuOption menu, int count, int minimumOrderPrice) {
        this.menu = menu;
        this.count = count;
        this.minimumOrderPrice = minimumOrderPrice;
    }

    public MenuOption getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }

    public boolean receiveGift(int amount) {
        return amount >= this.minimumOrderPrice;
    }

}
