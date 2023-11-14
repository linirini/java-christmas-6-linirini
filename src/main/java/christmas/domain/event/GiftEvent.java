package christmas.domain.event;

import christmas.domain.menu.MenuOption;
import java.awt.Menu;
import java.util.HashMap;

public class GiftEvent {

    private final static MenuOption GIFT = MenuOption.CHAMPAGNE;
    private final static int COUNT = 1;

    public HashMap<String,Integer> getGift(int amount){
        HashMap<String,Integer> gift = new HashMap<>();
        if(canReceiveGift(amount)){
            gift.put(GIFT.getViewName(),COUNT);
        }
        return gift;
    }

    private boolean canReceiveGift(int amount) {
        return amount >= 120000;
    }

}
