package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.util.ExceptionEnum.INVALID_DATE;
import static christmas.view.viewenum.InputEnum.ORDERS_INPUT;
import static christmas.view.viewenum.InputEnum.VISITING_DATE_INPUT;

import christmas.domain.Orders;
import christmas.domain.menu.MenuOption;
import christmas.util.DecemberCalender;
import java.util.HashMap;
import java.util.List;

public class InputView {

    public int inputVisitingDate(){
        System.out.println(VISITING_DATE_INPUT.getMessage());
        int date;
        try {
            date = Integer.parseInt(readLine());
        }catch (NumberFormatException NFE){
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
        throwIfInvalidDate(date);
        return date;
    }

    private void throwIfInvalidDate(int date) {
        if(!DecemberCalender.isValidDate(date)){
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public Orders inputOrders(){
        System.out.println(ORDERS_INPUT.getMessage());
        String input = readLine();
        HashMap<MenuOption,Integer> orders = parseInputIntoMenus(input);
        return new Orders(orders);
    }

    private HashMap<MenuOption, Integer> parseInputIntoMenus(String input) {
        return null;
    }

}
