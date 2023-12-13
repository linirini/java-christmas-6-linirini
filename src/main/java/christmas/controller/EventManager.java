package christmas.controller;

import static christmas.util.ExceptionEnum.INVALID_DATE;
import static christmas.util.ExceptionEnum.INVALID_ORDER;

import christmas.domain.Badge;
import christmas.domain.Benefit;
import christmas.domain.Gift;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class EventManager {

    private final EventPlanner eventPlanner = new EventPlanner();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.printEventIntroduction();
        int date = inputReservationDateUntilNoError();
        Orders orders = inputOrdersUntilNoError();
        outputView.printOrders(orders);
        outputView.printBenefitsNotice(date);
        int totalOrdersPrice = getTotalOrdersPriceAndPrint(orders);
        Benefit benefit = eventPlanner.applyEvents(date,orders);
        printGiftMenu(benefit);
        outputView.printBenefits(benefit);
        int totalBenefitsPrice = getTotalBenefitsPriceAndPrint(benefit);
        printTotalOrdersPrice(totalOrdersPrice, benefit);
        getBadgeAndPrint(totalBenefitsPrice);
    }

    private int inputReservationDateUntilNoError() {
        while (true) {
            String input = inputView.inputReservationDate();
            try {
                int date = getDate(input);
                throwIfInvalidDate(date);
                return date;
            } catch (Exception e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static int getDate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException NFE) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    private void throwIfInvalidDate(int date) {
        if (!eventPlanner.isValidDate(date)) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    private Orders inputOrdersUntilNoError() {
        while (true) {
            String input = inputView.inputOrders();
            try {
                return new Orders(convertToOrders(input));
            } catch (Exception e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private HashMap<String, Integer> convertToOrders(String input) {
        List<String> menuOptionsAndCounts = splitByRegex(input, ",");
        return convertToMenuOptionsAndCounts(menuOptionsAndCounts);
    }

    private HashMap<String, Integer> convertToMenuOptionsAndCounts(
            List<String> menuOptionsWithCounts) {
        HashMap<String, Integer> orders = new HashMap<>();
        for (String menuOptionsWithCount : menuOptionsWithCounts) {
            List<String> menuOptionAndCount = splitByRegex(menuOptionsWithCount, "-");
            String menuOption = menuOptionAndCount.get(0);
            int count = convertToCount(menuOptionAndCount.get(1));
            throwIfDuplicatedMenuOptions(menuOption, orders);
            orders.put(menuOption, count);
        }
        return orders;
    }

    private static List<String> splitByRegex(String menuOptionsWithCount, String regex) {
        try {
            return Arrays.stream(menuOptionsWithCount.split(regex))
                    .toList();
        } catch (PatternSyntaxException PSE) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private int convertToCount(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException NFE) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private void throwIfDuplicatedMenuOptions(String menuOption, HashMap<String, Integer> orders) {
        if (orders.containsKey(menuOption)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private int getTotalOrdersPriceAndPrint(Orders orders) {
        int totalOrdersPrice = orders.getTotalPrice();
        outputView.printTotalOrdersPrice(totalOrdersPrice);
        return totalOrdersPrice;
    }

    private void printGiftMenu(Benefit benefit) {
        Gift gift = benefit.getGiftEventBenefit();
        outputView.printGiftMenu(gift);
    }

    private int getTotalBenefitsPriceAndPrint(Benefit benefit) {
        int totalBenefitsPrice = benefit.getTotalBenefitsPrice();
        outputView.printTotalBenefitsPrice(totalBenefitsPrice);
        return totalBenefitsPrice;
    }

    private void printTotalOrdersPrice(int totalOrdersPrice, Benefit benefit) {
        int actualPaymentPrice = eventPlanner.getActualPaymentPrice(totalOrdersPrice, benefit);
        outputView.printActualPaymentPrice(actualPaymentPrice);
    }

    private void getBadgeAndPrint(int totalBenefitsPrice) {
        Badge badge = eventPlanner.getBadge(totalBenefitsPrice);
        outputView.printEventBadge(badge);
    }

}
