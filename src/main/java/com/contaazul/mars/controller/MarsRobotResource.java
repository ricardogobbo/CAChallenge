package com.contaazul.mars.controller;

import com.contaazul.mars.service.RobotHandlerService;
import com.contaazul.mars.service.factory.RobotHandlerServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/mars")
public class MarsRobotResource {

    @POST
    @Path("/{command}")
    public Response moveRobot(@PathParam("command") String command) {
        RobotHandlerService robotHandlerService =
                new RobotHandlerServiceFactory().createRobotHandlerService();
        try {
            robotHandlerService.handle(command);
            return Response.status(200)
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .entity(robotHandlerService.getRobot())
                    .build();
        }catch (Exception e){
            return Response.status(400)
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .entity("400 Bad Request")
                    .build();
        }
    }


}