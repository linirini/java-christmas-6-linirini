package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.util.DecemberCalender.isValidDate;
import static christmas.util.ExceptionEnum.INVALID_DATE;
import static christmas.util.ExceptionEnum.INVALID_ORDERS;
import static christmas.view.viewenum.InputEnum.ORDERS_INPUT;
import static christmas.view.viewenum.InputEnum.VISITING_DATE_INPUT;

import christmas.domain.Orders;
import christmas.domain.menu.MenuOption;
import java.util.HashMap;

public class InputView {

    public int inputVisitingDate() {
        System.out.println(VISITING_DATE_INPUT.getMessage());
        int date;
        try {
            date = Integer.parseInt(readLine());
        } catch (NumberFormatException NFE) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
        throwIfInvalidDate(date);
        return date;
    }

    private void throwIfInvalidDate(int date) {
        if (!isValidDate(date)) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public Orders inputOrders() {
        System.out.println(ORDERS_INPUT.getMessage());
        String input = readLine();
        HashMap<MenuOption, Integer> orders = parseInputToOrders(input);
        return new Orders(orders);
    }

    private HashMap<MenuOption, Integer> parseInputToOrders(String input) {
        String[] menusWithCount = input.split(",");
        HashMap<MenuOption, Integer> orders = parseMenusWithCountToOrders(menusWithCount);
        return orders;
    }

    private HashMap<MenuOption, Integer> parseMenusWithCountToOrders(String[] menusWithCount) {
        HashMap<MenuOption, Integer> orders = new HashMap<>();
        for (String menuWithCount : menusWithCount) {
            String[] menuAndCount = parseToMenuAndCount(menuWithCount);
            MenuOption menuOption = convertMenuToMenuOption(menuAndCount[0]);
            int count = convertCountToInteger(menuAndCount[1]);
            throwIfInvalidCount(count);
            throwIfAlreadyOrderedMenu(orders, menuOption);
            orders.put(menuOption, count);
        }
        return orders;
    }

    private String[] parseToMenuAndCount(String menuWithCount) {
        try {
            String[] menuAndCount = menuWithCount.split("-");
            throwIfInvalidForm(menuAndCount);
            return menuAndCount;
        } catch (Exception E) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private void throwIfInvalidForm(String[] menuAndCount) {
        if (menuAndCount.length != 2) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private MenuOption convertMenuToMenuOption(String menu) {
        MenuOption menuOption = MenuOption.findMenuOption(menu);
        throwIfMenuNotExist(menuOption);
        return menuOption;
    }

    private void throwIfMenuNotExist(MenuOption menuOption) {
        if (menuOption == MenuOption.NO_MENU) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private int convertCountToInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException NFE) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private void throwIfInvalidCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private void throwIfAlreadyOrderedMenu(HashMap<MenuOption, Integer> menusAndCount,
            MenuOption menuOption) {
        if (menusAndCount.containsKey(menuOption)) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

}
