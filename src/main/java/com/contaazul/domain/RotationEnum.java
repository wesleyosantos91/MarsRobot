package com.contaazul.domain;

import lombok.Getter;

@Getter
public enum RotationEnum {

    LEFT("L", -90),
    RIGHT("R", 90);

    private final String symbol;
    private final int value;

    RotationEnum(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }
}
