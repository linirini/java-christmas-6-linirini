package christmas.domain.menu;

import java.util.Arrays;

public enum MenuType {

    APPETIZER("에피타이저",
            new MenuOption[]{MenuOption.MUSHROOM_SOUP, MenuOption.TAPAS, MenuOption.CAESAR_SALAD}),
    MAIN_DISH("메인",
            new MenuOption[]{MenuOption.T_BONE_STEAK, MenuOption.BBQ_RIBS, MenuOption.SEAFOOD_PASTA,
                    MenuOption.CHRISTMAS_PASTA}),
    DESSERT("디저트", new MenuOption[]{MenuOption.CHOCO_CAKE, MenuOption.ICE_CREAM}),
    BEVERAGE("음료",
            new MenuOption[]{MenuOption.ZERO_COKE, MenuOption.RED_WINE, MenuOption.CHAMPAGNE});

    private final String viewName;

    private final MenuOption[] containMenu;

    MenuType(String viewName, MenuOption[] containMenu) {
        this.viewName = viewName;
        this.containMenu = containMenu;
    }


    public static MenuType findMenuType(String target) {
        return Arrays.stream(MenuType.values()).filter(group -> hasMenuOption(group, target))
                .findAny().get();
    }

    private static boolean hasMenuOption(MenuType group, String target) {
        return Arrays.stream(group.containMenu)
                .anyMatch(contain -> contain.getViewName().equals(target));
    }

}
