package com.contaazul.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope(scopeName="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Robot {

    private OrientationEnum orientation;
    private int xCoord;
    private int yCoord;

    public Robot() {
        this.xCoord = 0;
        this.yCoord = 0;
        this.orientation = OrientationEnum.NORTH;
    }

    public void rotate(RotationEnum rotation) {
        orientation = orientation.getFinalOrientation(rotation.getValue());
    }

    public void move() {
        switch (orientation) {
            case NORTH:
                yCoord++;
                break;
            case SOUTH:
                yCoord--;
                break;
            case EAST:
                xCoord++;
                break;
            case WEST:
                xCoord--;
                break;
        }
    }
}
