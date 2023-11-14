package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.util.ExceptionEnum.INVALID_DATE;
import static christmas.util.ExceptionEnum.INVALID_ORDERS;
import static christmas.view.viewenum.InputEnum.ORDERS_INPUT;
import static christmas.view.viewenum.InputEnum.VISITING_DATE_INPUT;

import christmas.domain.Orders;
import christmas.domain.menu.MenuOption;
import christmas.util.DecemberCalender;
import java.util.HashMap;
import java.util.Map;

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
        if (!DecemberCalender.isValidDate(date)) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public Orders inputOrders() {
        System.out.println(ORDERS_INPUT.getMessage());
        String input = readLine();
        HashMap<MenuOption, Integer> menusAndCount = parseInputToMenusAndCount(input);
        return new Orders(menusAndCount);
    }

    private HashMap<MenuOption, Integer> parseInputToMenusAndCount(String input) {
        String[] menusWithCount = input.split(",");
        HashMap<MenuOption, Integer> menusAndCount = parseToMenuAndCount(menusWithCount);
        return menusAndCount;
    }

    private HashMap<MenuOption, Integer> parseToMenuAndCount(String[] menusWithCount) {
        HashMap<MenuOption, Integer> menusAndCount = new HashMap<>();
        for (String menuWithCount : menusWithCount) {
            String[] menuAndCount = menuWithCount.split("-");
            throwIfInvalidForm(menuAndCount);
            MenuOption menuOption = convertMenuToMenuOption(menuAndCount[0]);
            int count = convertCountToInteger(menuAndCount[1]);
            throwIfInvalidCount(count);
            throwIfAlreadyOrderedMenu(menusAndCount, menuOption);
            menusAndCount.put(menuOption, count);
        }
        return menusAndCount;
    }

    private void throwIfInvalidForm(String[] menuAndCount) {
        if (menuAndCount.length != 2) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private MenuOption convertMenuToMenuOption(String menu) {
        try{
            return null;
        }catch(Exception e){

        }
        return null;
    }

    private int convertCountToInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException NFE) {
            throw new IllegalArgumentException();
        }
    }

    private void throwIfInvalidCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private void throwIfAlreadyOrderedMenu(HashMap<MenuOption, Integer> menusAndCount, MenuOption menuOption) {
        if (menusAndCount.containsKey(menuOption)) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

}
