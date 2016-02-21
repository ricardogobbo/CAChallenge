package com.contaazul.mars.service;

import com.contaazul.mars.exception.RobotException;
import com.contaazul.mars.model.Area;
import com.contaazul.mars.model.Robot;
import com.contaazul.mars.model.Rotation;

public class RobotHandlerService {

    public static final String INVALID_COMMAND_MESSAGE = "INVALID COMMAND";
    public static final String POSITION_OUT_OF_BOUNDS_MESSAGE = "POSITION OUT OF BOUNDS";

    private Robot robot;
    private Area area;

    public RobotHandlerService(Robot robot, Area area) {
        this.robot = robot;
        this.area = area;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void handle(String command) throws RobotException {

        command = command.toUpperCase();

        if(!command.matches("[MRL]+")){
            throw new RobotException(INVALID_COMMAND_MESSAGE);
        }

        for (int i = 0; i < command.length(); i++) {

            switch (command.charAt(i)){
                case 'M':
                    if(area.isPositionInArea(robot.nextStepPosition()))
                        robot.stepMove();
                    else
                        throw new RobotException(POSITION_OUT_OF_BOUNDS_MESSAGE);
                    break;
                case 'R':
                    robot.rotate(Rotation.RIGHT);
                    break;
                case 'L':
                    robot.rotate(Rotation.LEFT);
                    break;
            }
        }

    }


}
