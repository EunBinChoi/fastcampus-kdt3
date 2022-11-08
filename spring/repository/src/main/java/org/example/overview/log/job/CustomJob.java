package org.example.overview.log.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CustomJob implements Job {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("DEBUG LOG");
        logger.trace("TRACE LOG");
        logger.info("INFO LOG");
        logger.warn("WARN LOG");
        logger.error("ERROR LOG");
    }
}
