package com.contaazul.mars.model.factory;

import com.contaazul.mars.model.Direction;
import com.contaazul.mars.model.Position;
import com.contaazul.mars.model.Robot;

public class RobotFactory {

    public Robot createRobot(){
        return new Robot(new Position(0, 0), Direction.NORTH);
    }
}
