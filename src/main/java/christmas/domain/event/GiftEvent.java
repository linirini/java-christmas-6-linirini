package christmas.domain.event;

import christmas.domain.menu.MenuOption;

public class GiftEvent {

    private final static MenuOption GIFT = MenuOption.CHAMPAGNE;

    public static boolean canReceiveGift(int amount) {
        return amount >= 120000;
    }

}
