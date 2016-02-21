package com.contaazul.mars;

import com.contaazul.mars.controller.MarsRobotResource;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class MarsRobotResourceTest {

    public void postResourceTest(){
        String command = "MML";
        MarsRobotResource marsRobotResource = new MarsRobotResource();
        Response response = marsRobotResource.moveRobot(command);

        assertEquals(200, response.getStatus());
        //assertEquals("(0, 2, W)", response.toString());
    }


}
