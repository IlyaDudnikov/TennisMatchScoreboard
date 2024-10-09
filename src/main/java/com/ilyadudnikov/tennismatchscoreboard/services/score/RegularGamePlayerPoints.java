package com.ilyadudnikov.tennismatchscoreboard.services.score;

public enum RegularGamePlayerPoints {
    ZERO, FIFTEEN, THIRTY, FORTY, ADVANTAGE;

    public RegularGamePlayerPoints next() {
        if (this == ADVANTAGE) {
            throw new IllegalStateException("Невозможно вызвать next() на ADVANTAGE");
        } else {
            return RegularGamePlayerPoints.values()[this.ordinal() + 1];
        }
    }
}
