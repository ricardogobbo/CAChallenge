package com.contaazul.mars;

import com.contaazul.mars.model.Direction;
import com.contaazul.mars.model.Position;
import com.contaazul.mars.model.Robot;
import com.contaazul.mars.model.Rotation;
import com.contaazul.mars.model.factory.RobotFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RobotTest {


    @Test
    public void robotInitialStateTest(){
        Robot robot = new RobotFactory().createRobot();
        assertNotNull(robot);
        assertEquals(new Position(0, 0), robot.getPosition());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void robotRotationTest(){
        Robot robot = new RobotFactory().createRobot();
        robot.rotate(Rotation.LEFT);
        assertEquals(Direction.WEST, robot.getDirection());
        robot.rotate(Rotation.LEFT);
        assertEquals(Direction.SOUTH, robot.getDirection());
        robot.rotate(Rotation.LEFT);
        assertEquals(Direction.EAST, robot.getDirection());
        robot.rotate(Rotation.LEFT);
        assertEquals(Direction.NORTH, robot.getDirection());
        robot.rotate(Rotation.RIGHT);
        robot.rotate(Rotation.RIGHT);
        robot.rotate(Rotation.RIGHT);
        assertEquals(Direction.WEST, robot.getDirection());
        robot.rotate(Rotation.RIGHT);
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void robotMovementTest(){
        Robot robot = new RobotFactory().createRobot();
        robot.stepMove();
        assertEquals(new Position(0, 1), robot.getPosition());
        robot.rotate(Rotation.RIGHT);
        robot.stepMove();
        robot.stepMove();
        assertEquals(new Position(2, 1), robot.getPosition());
        robot.rotate(Rotation.LEFT);
        robot.stepMove();
        robot.stepMove();
        assertEquals(new Position(2, 3), robot.getPosition());
        robot.rotate(Rotation.LEFT);
        robot.rotate(Rotation.LEFT);
        robot.rotate(Rotation.LEFT);
        robot.rotate(Rotation.LEFT);
        robot.stepMove();
        assertEquals(new Position(2, 4), robot.getPosition());

    }
}
