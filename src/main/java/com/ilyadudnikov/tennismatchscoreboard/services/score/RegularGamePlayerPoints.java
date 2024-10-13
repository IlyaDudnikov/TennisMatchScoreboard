package com.ilyadudnikov.tennismatchscoreboard.services.score;

import java.util.Map;

public enum RegularGamePlayerPoints {
    ZERO, FIFTEEN, THIRTY, FORTY, ADVANTAGE;

    private static final Map<RegularGamePlayerPoints, String> displayNames = Map.of(
            ZERO, "0",
            FIFTEEN, "15",
            THIRTY, "30",
            FORTY, "40",
            ADVANTAGE, "AD"
    );

    public RegularGamePlayerPoints next() {
        if (this == ADVANTAGE) {
            throw new IllegalStateException("Невозможно вызвать next() на ADVANTAGE");
        } else {
            return RegularGamePlayerPoints.values()[this.ordinal() + 1];
        }
    }

    @Override
    public String toString() {
        return displayNames.get(this);
    }
}
