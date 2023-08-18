package com.contaazul.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrientationEnum {

    NORTH("N", 0),
    SOUTH("S", 180),
    WEST("W", 270),
    EAST("E", 90);

    private final String symbol;
    private final int value;

    public static OrientationEnum findBySymbol(String symbol) {
        for (OrientationEnum orientationEnum : values()) {
            if (orientationEnum.symbol.equals(symbol)) {
                return orientationEnum;
            }
        }
        throw new IllegalArgumentException("Invalid symbol");
    }

    public OrientationEnum getFinalOrientation(int rotationValue) {
        int finalOrientationValue = (value + rotationValue + 360) % 360;

        for (OrientationEnum enumValue : values()) {
            if (enumValue.value == finalOrientationValue) {
                return enumValue;
            }
        }

        throw new IllegalArgumentException("Invalid rotation value");
    }
}
