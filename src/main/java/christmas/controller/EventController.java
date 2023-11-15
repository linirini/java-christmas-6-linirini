package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.event.EventBenefit;
import christmas.domain.event.EventPlanner;
import christmas.domain.event.Gift;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    private static final int ZERO = 0;
    private static final EventBenefit NO_BENEFIT = EventBenefit.getDefaultEventBenefit();

    private final EventPlanner eventPlanner = new EventPlanner();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printEventPlannerIntroduction();
        int date = inputDateUntilNoError();
        Orders orders = inputOrdersUntilNoError();
        outputView.printBenefitIntroductionAtDate(date);
        printOrder(orders);
        int totalAmountBeforeDiscount = getTotalAmountBeforeDiscountAndPrint(orders);
    }

    private int inputDateUntilNoError() {
        while (true) {
            try {
                return inputView.inputVisitingDate();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Orders inputOrdersUntilNoError() {
        while (true) {
            try {
                return inputView.inputOrders();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printOrder(Orders orders) {
        outputView.printLineBreak();
        outputView.printOrderedMenus(orders.getOrderedMenusAndCount());
    }

    private int getTotalAmountBeforeDiscountAndPrint(Orders orders) {
        outputView.printLineBreak();
        int totalAmountBeforeDiscount = orders.getTotalOrderAmount();
        outputView.printOrdersAmount(totalAmountBeforeDiscount);
        return totalAmountBeforeDiscount;
    }


}
