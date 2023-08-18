package com.contaazul.service.strategy;

import com.contaazul.domain.Robot;
import com.contaazul.domain.RotationEnum;

public enum CommandStrategy {
    MOVE {
        @Override
        public void execute(Robot robot) {
            robot.move();
        }
    },
    LEFT {
        @Override
        public void execute(Robot robot) {
            robot.rotate(RotationEnum.LEFT);
        }
    },
    RIGHT {
        @Override
        public void execute(Robot robot) {
            robot.rotate(RotationEnum.RIGHT);
        }
    };

    public abstract void execute(Robot robot);
}