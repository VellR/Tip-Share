package com.nightonke.boommenu.Types;

public enum BoomType {
    LINE(0),
    PARABOLA(1),
    HORIZONTAL_THROW(2),
    PARABOLA_2(3),
    HORIZONTAL_THROW_2(4);
    
    int type;

    private BoomType(int type2) {
        this.type = type2;
    }
}
