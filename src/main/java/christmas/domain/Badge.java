package christmas.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Badge {

    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NONE("없음", 0);

    private final String name;

    private final int minimumAmount;

    Badge(String name, int minimumAmount) {
        this.name = name;
        this.minimumAmount = minimumAmount;
    }

    public static Badge getBadge(int amount) {
        return Arrays.stream(values()).filter(badge -> amount >= badge.minimumAmount)
                .collect(Collectors.toList()).stream().max(Badge::getMinimumAmount).orElse(NONE);
    }

    private int getMinimumAmount(Badge badge) {
        return badge.minimumAmount;
    }

}
