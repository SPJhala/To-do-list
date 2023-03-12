package com.list;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.inject.Inject;
import javax.swing.*;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(ActivityMain.class, args);
    }

        public static class ActivityMain implements QuarkusApplication{
            @Inject
            ActivityResource activityResource;

            @Override
            public int run(String... args) {

                System.out.println("Running quarkus");
                while(JOptionPane.showConfirmDialog(null,"Do you want to continue?","Continue",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

                    if(JOptionPane
                            .showConfirmDialog(null, "Do you want to add activity?", "Add Activity",JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION){
                        String activityName = JOptionPane.showInputDialog(null,"Enter Activity Name: ");
                        Activity act = new Activity(activityName);
                        activityResource.addActivity(act);
                    } else if (JOptionPane
                            .showConfirmDialog(null, "Do you want to remove activity?", "Remove Activity",JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        String activityName = JOptionPane.showInputDialog(null,"Enter Activity Name: ");
                        activityResource.deleteActivity(activityName);
                    }
                }
                JOptionPane.showMessageDialog(null,activityResource.displayList().toString());
                Quarkus.waitForExit();
                return 0;
            }
        }
}
