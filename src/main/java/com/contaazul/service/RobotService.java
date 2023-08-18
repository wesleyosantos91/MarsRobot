package com.contaazul.service;

import com.contaazul.domain.Robot;
import com.contaazul.exception.ValidationException;
import com.contaazul.service.factory.CommandFactory;
import com.contaazul.service.strategy.CommandStrategy;
import com.contaazul.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RobotService {

    private final Robot robot;

    public String executeInstructions(String instructions) throws ValidationException {

        for (char command : instructions.toCharArray()) {
            CommandStrategy commandStrategy = CommandFactory.createCommand(command);
            commandStrategy.execute(robot);
        }

        ValidationUtils.validateCoords(robot.getXCoord(), robot.getYCoord());

        return "(" + robot.getXCoord() + "," + robot.getYCoord() + "," + robot.getOrientation().getSymbol() + ")";
    }
}
