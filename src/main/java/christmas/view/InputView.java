package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.util.ExceptionEnum.INVALID_DATE;

import christmas.util.DecemberCalender;

public class InputView {

    public int inputVisitingDate(){
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

}
