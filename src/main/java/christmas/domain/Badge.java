package christmas.domain;

public enum Badge {
    ;


    private final String name;

    private final int minimumAmount;

    Badge(String name, int minimumAmount) {
        this.name = name;
        this.minimumAmount = minimumAmount;
    }


}
