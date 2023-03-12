package com.list;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.annotation.JsonbProperty;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("/activities")
@ApplicationScoped
public class ActivityResource{

    private List<Activity> activities = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> displayList(){
        return activities;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addActivity(@JsonbProperty("Activity name") Activity act){
        activities.add(act);
        System.out.println("Activity Added");
        return Response.ok(act).build();
    }
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    public void deleteActivity(String activityName){
        if(activities.remove(
                activities.stream()
                        .filter(activity -> activityName
                                .equalsIgnoreCase(activity.getName()))
                        .findFirst().orElse(null))){
            System.out.println("Activity Deleted");
        }
        else
            System.out.println("Activity not found!");
    }
}