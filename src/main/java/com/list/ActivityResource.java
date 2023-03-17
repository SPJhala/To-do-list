package com.list;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.annotation.JsonbProperty;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("/activities")
@ApplicationScoped
public class ActivityResource{

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> displayList(){
        List<Activity> activities = Activity.listAll();
        return activities;
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addActivity(@JsonbProperty("Activity name") Activity act){
        Activity.persist(act);
        if(act.isPersistent()) {
            System.out.println("Activity Added");
            return Response.created(URI.create("/activities/" + act.id)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Transactional
    @Consumes(MediaType.TEXT_PLAIN)
    public void deleteActivity(String activityName){
        Activity.delete("Activity_Name",activityName);
        System.out.println("Activity Removed");
    }
}