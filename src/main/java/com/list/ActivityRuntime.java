package com.list;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class ActivityRuntime {
    @Inject
    ActivityResource activityResource;

    public void callAddActivity(){
        Activity act = new Activity("Reading");
        activityResource.addActivity(act);
    }
}
