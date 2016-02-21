package com.contaazul.mars;

import com.contaazul.mars.controller.MarsRobotResource;
import com.contaazul.mars.model.Robot;
import com.contaazul.mars.server.InMemoryServer;
import org.junit.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class MarsRobotResourceTest {

    public static MarsRobotResource sut = new MarsRobotResource();
    public static InMemoryServer server;

    @Before
    public void beforeClass() throws Exception {
        server = InMemoryServer.create(sut);
    }

    @After
    public void afterClass() throws Exception {
        server.close();
    }

    @Test
    public void postToMarsRobotTest() {

        Response response = server.newRequest("/mars/MML")
                .request()
                .buildPost(Entity.text(""))
                .invoke();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());


    }

    @Test
    public void invalidPostToMarsRobotTest(){
        Response response = server.newRequest("/mars/MMRAL")
                .request()
                .buildPost(Entity.text(""))
                .invoke();
        assertEquals(400, response.getStatus());
    }

    @Test
    public void outOfBoundsPostToMarsRobotTest(){
        Response response = server.newRequest("/mars/MMMMMMMMMMMMMMMMM")
                .request()
                .buildPost(Entity.text(""))
                .invoke();
        assertEquals(400, response.getStatus());
    }

}
