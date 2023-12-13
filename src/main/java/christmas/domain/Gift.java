package christmas.domain;

import static christmas.domain.menu.MenuOption.CHAMPAGNE;

import christmas.domain.menu.MenuOption;
import java.util.Arrays;

public enum Gift {

    GIFT(CHAMPAGNE, 1, 120000),
    NONE(MenuOption.NONE, 0, 0);

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

    public static Gift receiveGift(int amount) {
        return Arrays.stream(values()).filter(gift -> amount >= gift.minimumOrderPrice && gift != NONE)
                .findFirst().orElse(NONE);
    }

}
