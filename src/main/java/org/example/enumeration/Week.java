package org.example.enumeration;

public enum Week {
    BAD(0),
    NORMAL(1),
    GOOD(3);

    public final int eggCount;

    Week(int eggCount) {
        this.eggCount = eggCount;
    }
}
