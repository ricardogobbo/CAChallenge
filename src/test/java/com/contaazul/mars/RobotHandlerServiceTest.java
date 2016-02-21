package com.contaazul.mars;

import com.contaazul.mars.exception.RobotException;
import com.contaazul.mars.model.Area;
import com.contaazul.mars.model.Direction;
import com.contaazul.mars.model.Position;
import com.contaazul.mars.model.Robot;
import com.contaazul.mars.model.factory.AreaFactory;
import com.contaazul.mars.model.factory.RobotFactory;
import com.contaazul.mars.service.RobotHandlerService;
import com.contaazul.mars.service.factory.RobotHandlerServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RobotHandlerServiceTest {

    @Test
    public void invalidCommandException(){
        Robot robot = new RobotFactory().createRobot();
        Area area = new AreaFactory().createArea();
        RobotHandlerService robotHandlerService = new RobotHandlerService(robot, area);

        try {
            String command = "VPA";
            robotHandlerService.handle(command);
            fail();
        } catch (RobotException e) {
            assertEquals(RobotHandlerService.INVALID_COMMAND_MESSAGE, e.getMessage());
        }

        try {
            String command = "MMRAMM";
            robotHandlerService.handle(command);
            fail();
        } catch (RobotException e) {
            assertEquals(RobotHandlerService.INVALID_COMMAND_MESSAGE, e.getMessage());
        }

        try {
            String command = "MRaA+5%L";
            robotHandlerService.handle(command);
            fail();
        } catch (RobotException e) {
            assertEquals(RobotHandlerService.INVALID_COMMAND_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void moveRobotViaHandlerTest(){

        RobotHandlerService robotHandlerService = new RobotHandlerServiceFactory().createRobotHandlerService();

        try{
            String command = "MMRMM";
            robotHandlerService.handle(command);
            assertEquals(new Position(2, 2), robotHandlerService.getRobot().getPosition());
            assertEquals(Direction.EAST, robotHandlerService.getRobot().getDirection());

            command = "LMMLM";
            robotHandlerService.handle(command);
            assertEquals(new Position(1, 4), robotHandlerService.getRobot().getPosition());
            assertEquals(Direction.WEST, robotHandlerService.getRobot().getDirection());

            command = "MRRMMMMRMMMMRMMMMR";
            robotHandlerService.handle(command);
            assertEquals(new Position(0, 0), robotHandlerService.getRobot().getPosition());
            assertEquals(Direction.NORTH, robotHandlerService.getRobot().getDirection());

        }catch (Exception e){
            fail();
        }

    }

    @Test
    public void challengeMovementTest(){

        try{
            RobotHandlerService robotHandlerService = new RobotHandlerServiceFactory().createRobotHandlerService();
            String command = "MMRMMRMM";
            robotHandlerService.handle(command);
            assertEquals(new Position(2, 0), robotHandlerService.getRobot().getPosition());
            assertEquals(Direction.SOUTH, robotHandlerService.getRobot().getDirection());

            robotHandlerService = new RobotHandlerServiceFactory().createRobotHandlerService();
            command = "MML";
            robotHandlerService.handle(command);
            assertEquals(new Position(0, 2), robotHandlerService.getRobot().getPosition());
            assertEquals(Direction.WEST, robotHandlerService.getRobot().getDirection());

            robotHandlerService = new RobotHandlerServiceFactory().createRobotHandlerService();
            command = "MML";
            robotHandlerService.handle(command);
            assertEquals(new Position(0, 2), robotHandlerService.getRobot().getPosition());
            assertEquals(Direction.WEST, robotHandlerService.getRobot().getDirection());

        }catch (Exception e){
            fail();
        }

        try {
            RobotHandlerService robotHandlerService = new RobotHandlerServiceFactory().createRobotHandlerService();
            String command = "AAA";
            robotHandlerService.handle(command);
            fail();
        } catch (RobotException e) {
            assertEquals(RobotHandlerService.INVALID_COMMAND_MESSAGE, e.getMessage());
        }

        try {
            RobotHandlerService robotHandlerService = new RobotHandlerServiceFactory().createRobotHandlerService();
            String command = "MMMMMMMMMMMMMMMMMMMMMMMM";
            robotHandlerService.handle(command);
            fail();
        } catch (RobotException e) {
            assertEquals(RobotHandlerService.POSITION_OUT_OF_BOUNDS_MESSAGE, e.getMessage());
        }
    }
}
