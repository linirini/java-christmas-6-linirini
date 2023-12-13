package christmas.domain.menu;

import static christmas.domain.menu.MenuOption.BBQ_LIP;
import static christmas.domain.menu.MenuOption.CAESAR_SALAD;
import static christmas.domain.menu.MenuOption.CHAMPAGNE;
import static christmas.domain.menu.MenuOption.CHOCO_CAKE;
import static christmas.domain.menu.MenuOption.CHRISTMAS_PASTA;
import static christmas.domain.menu.MenuOption.ICE_CREAM;
import static christmas.domain.menu.MenuOption.MUSHROOM_SOUP;
import static christmas.domain.menu.MenuOption.RED_WINE;
import static christmas.domain.menu.MenuOption.SEAFOOD_PASTA;
import static christmas.domain.menu.MenuOption.TAPAS;
import static christmas.domain.menu.MenuOption.T_BONE_STEAK;
import static christmas.domain.menu.MenuOption.ZERO_COKE;

import java.util.Arrays;
import java.util.List;

public enum MenuGroup {

    APPETIZER("애피타이저", List.of(MUSHROOM_SOUP, TAPAS, CAESAR_SALAD)),
    MAIN_DISH("메인", List.of(T_BONE_STEAK, BBQ_LIP, SEAFOOD_PASTA, CHRISTMAS_PASTA)),
    DESSERT("디저트", List.of(CHOCO_CAKE, ICE_CREAM)),
    BEVERAGE("음료", List.of(ZERO_COKE, RED_WINE, CHAMPAGNE)),
    NONE("없음", List.of());

    private final String name;
    private final List<MenuOption> menuOptions;

    MenuGroup(String name, List<MenuOption> menuOptions) {
        this.name = name;
        this.menuOptions = menuOptions;
    }

    public static final MenuGroup findMenuGroup(MenuOption menuOption) {
        return Arrays.stream(MenuGroup.values())
                .filter(menuGroup -> menuGroup.menuOptions.contains(menuOption)).findFirst()
                .orElse(NONE);
    }
}
