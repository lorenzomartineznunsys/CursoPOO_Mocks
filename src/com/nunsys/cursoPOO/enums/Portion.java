package com.nunsys.cursoPOO.enums;

/**
 * Created by lorenzo.martinez on 10/10/2016.
 */
public enum Portion {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private int size;

    private Portion(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }
}
