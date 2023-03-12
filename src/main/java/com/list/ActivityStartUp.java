package com.list;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class ActivityStartUp {
    @Inject
    ActivityResource activityResource;

    public void onStart(@Observes StartupEvent startupEvent){
        Activity activity = new Activity("Laughing");
        activityResource.addActivity(activity);
    }
}
