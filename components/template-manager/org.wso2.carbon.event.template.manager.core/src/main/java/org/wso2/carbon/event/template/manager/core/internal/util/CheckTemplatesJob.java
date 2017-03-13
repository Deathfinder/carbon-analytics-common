package org.wso2.carbon.event.template.manager.core.internal.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.wso2.carbon.event.template.manager.core.exception.TemplateManagerException;
import org.wso2.carbon.event.template.manager.core.internal.ds.TemplateManagerValueHolder;

/**
 * @author Anton Pashko.
 */
public class CheckTemplatesJob implements Job {
    private static final Log log = LogFactory.getLog(CheckTemplatesJob.class);

    public CheckTemplatesJob() {}

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            log.debug("Template reload job executed");
            TemplateManagerValueHolder.getTemplateManagerService().refreshDomains();
        } catch (TemplateManagerException e) {
            log.error("Can't reload templates", e);
        }

    }
}
