package christmas.domain.event.badge;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NO_BADGE("없음", 0);

    private final String viewName;

    private final int baseAmount;

    Badge(String viewName, int baseAmount) {
        this.viewName = viewName;
        this.baseAmount = baseAmount;
    }

    public String getViewName() {
        return viewName;
    }

    public int getBaseAmount() {
        return baseAmount;
    }
}