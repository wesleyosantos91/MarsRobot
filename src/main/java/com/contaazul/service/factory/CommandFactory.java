package com.contaazul.service.factory;

import com.contaazul.service.strategy.CommandStrategy;

public class CommandFactory {
    public static CommandStrategy createCommand(char command) {
        switch (command) {
            case 'M':
                return CommandStrategy.MOVE;
            case 'L':
                return CommandStrategy.LEFT;
            case 'R':
                return CommandStrategy.RIGHT;
            default:
                throw new IllegalArgumentException("Invalid command: " + command);
        }
    }
}

