package com.contaazul.utils;

import com.contaazul.exception.ValidationException;

public class ValidationUtils {


    public static void validateCoords(int x, int y) throws ValidationException {
        final int MIN = 0;
        final int MAX = 4;

        if(!(x <= MAX && x >= MIN && y <= MAX && y >= MIN )) {
            throw new ValidationException("Invalid position coordinates");
        }
    }
}
