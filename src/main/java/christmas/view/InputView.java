package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.util.ExceptionEnum.INVALID_DATE;
import static christmas.view.viewenum.InputEnum.ORDERS_INPUT;
import static christmas.view.viewenum.InputEnum.VISITING_DATE_INPUT;

import christmas.domain.Orders;
import christmas.util.DecemberCalender;
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
        if (!DecemberCalender.isValidDate(date)) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public Orders inputOrders() {
        System.out.println(ORDERS_INPUT.getMessage());
        String input = readLine();
        HashMap<String, Integer> menusAndCount = parseInputToMenusAndCount(input);
        return new Orders(menusAndCount);
    }

    private HashMap<String, Integer> parseInputToMenusAndCount(String input) {
        String[] menusWithCount = input.split(",");
        HashMap<String, Integer> menusAndCount = parseToMenuAndCount(menusWithCount);
        return menusAndCount;
    }

    private HashMap<String, Integer> parseToMenuAndCount(String[] menusWithCount) {
        HashMap<String, Integer> menusAndCount = new HashMap<>();
        int totalCount = 0;
        for (String menuWithCount : menusWithCount) {
            String[] menuAndCount = menuWithCount.split("-");
            String menu = menuAndCount[0];
            int count = convertCountToInteger(menuAndCount[1]);
            menusAndCount.put(menu, count);
            totalCount += count;
        }
        return menusAndCount;
    }

    private int convertCountToInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException NFE) {
            throw new IllegalArgumentException();
        }
    }

}
