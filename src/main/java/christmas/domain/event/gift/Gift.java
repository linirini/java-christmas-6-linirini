package christmas.domain.event.gift;

import christmas.domain.menu.MenuOption;

public enum Gift {

    GIFT(MenuOption.CHAMPAGNE, 1),

    NO_GIFT(MenuOption.NO_MENU, 0);

    private static int MINIMUM = 120000;

    private final MenuOption menuOption;
    private final int count;

    Gift(MenuOption menuOption, int count) {
        this.menuOption = menuOption;
        this.count = count;
    }

    public static Gift receiveGift(int amount) {
        if (canReceiveGift(amount)) {
            return GIFT;
        }
        return NO_GIFT;
    }

    private static boolean canReceiveGift(int amount) {
        return amount >= MINIMUM;
    }

    public int getGiftBenefit() {
        return menuOption.getPrice() * count;
    }

    public String getGiftName() {
        return menuOption.getViewName();
    }

    public int getCount() {
        return count;
    }
}
