package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.event.EventBenefit;
import christmas.domain.event.EventPlanner;
import christmas.domain.event.Gift;
import christmas.domain.event.badge.Badge;
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
        Gift gift = getGiftAndPrint(totalAmountBeforeDiscount);
        EventBenefit eventBenefit = getEventBenefitAndPrintDetails(date, orders, gift);
        int benefitAmount = getTotalBenefitAmountAndPrint(eventBenefit);
        int discountAmount = eventBenefit.getTotalDiscountAmount();
        calculateExpectedPayAmountAndPrint(totalAmountBeforeDiscount,discountAmount);
        getEventBadgeAndPrint(benefitAmount);
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

    private Gift getGiftAndPrint(int totalAmountBeforeDiscount) {
        outputView.printLineBreak();
        Gift gift = Gift.receiveGift(totalAmountBeforeDiscount);
        outputView.printGiftMenu(gift);
        return gift;
    }

    private EventBenefit getEventBenefitAndPrintDetails(int date,
            Orders orders, Gift gift) {
        outputView.printLineBreak();
        EventBenefit eventBenefit;
        if (!eventPlanner.isMinimumAmountForEventMet(orders.getTotalOrderAmount())) {
            outputView.printNoneBenefit();
            eventBenefit = NO_BENEFIT;
            return eventBenefit;
        }
        eventBenefit = eventPlanner.calculateEventBenefit(date, orders, gift);
        outputView.printBenefitDetails(eventBenefit);
        return eventBenefit;
    }

    private int getTotalBenefitAmountAndPrint(EventBenefit eventBenefit) {
        outputView.printLineBreak();
        int totalBenefitAmount = eventBenefit.getTotalEventBenefit();
        outputView.printTotalBenefitAmount(totalBenefitAmount);
        return totalBenefitAmount;
    }

    private void calculateExpectedPayAmountAndPrint(int totalAmountBeforeDiscount,
            int discountAmount) {
        outputView.printLineBreak();
        int payAmount = eventPlanner.calculateExpectedPayAmount(totalAmountBeforeDiscount,
                discountAmount);
        outputView.printExpectedPayAmount(payAmount);
    }

    private void getEventBadgeAndPrint(int benefitAmount) {
        outputView.printLineBreak();
        Badge badge = Badge.determineBadge(benefitAmount);
        outputView.printEventBadge(badge.getViewName());
    }


}
