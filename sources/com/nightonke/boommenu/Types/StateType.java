package com.nightonke.boommenu.Types;

public enum StateType {
    CLOSED(0),
    OPENING(1),
    OPEN(2),
    CLOSING(3);
    
    int type;

    private StateType(int type2) {
        this.type = type2;
    }
}
