package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.event.EventBenefit;
import christmas.domain.event.EventPlanner;
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


}
