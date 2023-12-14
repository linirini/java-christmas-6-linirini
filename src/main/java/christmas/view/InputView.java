package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.view.InputEnum.ORDERS_INPUT;
import static christmas.view.InputEnum.RESERVATION_DATE_INPUT;

public class InputView {

    public String inputReservationDate(){
        System.out.println(RESERVATION_DATE_INPUT.getMessage());
        return readLine();
    }

    public String inputOrders(){
        System.out.println(ORDERS_INPUT.getMessage());
        return readLine();
    }
}
