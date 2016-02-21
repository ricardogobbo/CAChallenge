package com.contaazul.mars.service.factory;

import com.contaazul.mars.model.Area;
import com.contaazul.mars.model.Robot;
import com.contaazul.mars.model.factory.AreaFactory;
import com.contaazul.mars.model.factory.RobotFactory;
import com.contaazul.mars.service.RobotHandlerService;

/**
 * Created by Gobbo on 20/02/2016.
 */
public class RobotHandlerServiceFactory {

    public RobotHandlerService createRobotHandlerService(){
        Robot robot = new RobotFactory().createRobot();
        Area area = new AreaFactory().createArea();
        return new RobotHandlerService(robot, area);
    }
}
