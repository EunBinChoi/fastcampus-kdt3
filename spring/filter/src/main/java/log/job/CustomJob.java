package log.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CustomJob implements Job {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//      logger.trace("TRACE LOG"); // logger 등록되어있지 않기 때문에 출력이 안됨
        logger.debug("DEBUG LOG");
        logger.info("INFO LOG");
        logger.warn("WARN LOG");
        logger.error("ERROR LOG");
    }
}
