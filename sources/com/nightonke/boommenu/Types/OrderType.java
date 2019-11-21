package com.nightonke.boommenu.Types;

public enum OrderType {
    DEFAULT(0),
    REVERSE(1),
    RANDOM(2);
    
    int type;

    private OrderType(int type2) {
        this.type = type2;
    }
}
