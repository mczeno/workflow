package io.mczeno.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WorkflowStarter
 *
 * @author Chongming Zhou
 */
public class WorkflowStarter {

    private static final Logger log = LoggerFactory.getLogger(WorkflowStarter.class);

    public static void main(String[] args) throws Exception {
        log.info("Workflow start...");

        String pathname = null;
        if (args != null && args.length > 0) {
            pathname = args[0];
        }

        new TaskExecutorService().executeTasks(pathname);


        log.info("Workflow end.");
    }

}
