package io.mczeno.workflow;

import io.mczeno.workflow.parser.TaskParser;
import io.mczeno.workflow.parser.TaskParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

import static io.mczeno.workflow.constant.GlobalConstants.DEFAULT_JSON_TASK_FILE_NAME;
import static io.mczeno.workflow.constant.GlobalConstants.FILE_SEPARATOR_REGEX;

/**
 * TaskExecutorService
 *
 * @author Chongming Zhou
 */
public class TaskExecutorService {

    private static final Logger log = LoggerFactory.getLogger(WorkflowStarter.class);

    /**
     * 任务执行入口
     *
     * @param pathname 任务文件路径
     */
    public void executeTasks(String pathname) {
        File file = new File(getPathname(pathname));

        // 获取任务解析器
        String[] fileNameParts = file.getName().split(FILE_SEPARATOR_REGEX);
        String fileType = fileNameParts[fileNameParts.length - 1];
        TaskParser taskParser = new TaskParserFactory().getTaskParser(fileType);

        List<Task> tasks;
        try {
            tasks = taskParser.parseTasks(file);
        } catch (Exception e) {
            log.error("Task 解析异常", e);
            return;
        }

        // TODO: 2019-12-27 exec
        System.out.println(tasks);
    }

    /**
     * 文件名获取，如果未指定任务文件名，则使用默认
     *
     * @param pathname 指定的文件路径
     * @return 指定文件名或默认文件名
     */
    private String getPathname(String pathname) {
        return (pathname == null || pathname.isEmpty()) ? DEFAULT_JSON_TASK_FILE_NAME : pathname;
    }

}
