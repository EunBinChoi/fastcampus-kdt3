package org.example.overview.log.job;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CustomCronTrigger {
    private SchedulerFactory schedulerFactory = null;
    private Scheduler scheduler = null;
    public CustomCronTrigger() {
        try {
            schedulerFactory = new StdSchedulerFactory();
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }

    public void start() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            JobDetail job = newJob(CustomJob.class)
                    .withIdentity("jobName", "jobGroup")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("triggerName", "triggerGroup")
                    .withSchedule(cronSchedule("0/1 * * * * ?"))
                    .build();

            scheduler.scheduleJob(job, trigger);

            scheduler.start();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
