package io.mczeno.workflow;

import io.mczeno.workflow.parser.JsonTaskParser;
import io.mczeno.workflow.parser.TaskParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * TaskExecutorService
 *
 * @author Chongming Zhou
 */
public class TaskExecutorService {

    private static final Logger log = LoggerFactory.getLogger(WorkflowStarter.class);

    private static final String TASK_FILE_NAME = "workflow_task";
    private static final String TASK_FILE_TYPE_JSON = "json";
    private static final String FILE_SEPARATOR = "\\.";

    private static final String DEFAULT_JSON_TASK_FILE_NAME = String.join(FILE_SEPARATOR, TASK_FILE_NAME, TASK_FILE_TYPE_JSON);


    /**
     * 任务执行入口
     *
     * @param pathname 任务文件路径
     */
    public void executeTasks(String pathname) throws Exception {

        File file = new File(getPathname(pathname));

        // 获取任务解析器
        TaskParser taskParser = getTaskParser(file.getName());

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

    /**
     * 通过解析文件名获取对应的任务解析器
     *
     * @param fileName 文件名
     * @return 任务解析器
     * @see TaskParser
     */
    private TaskParser getTaskParser(String fileName) throws Exception {
        String[] fileNameParts = fileName.split(FILE_SEPARATOR);
        String fileType = fileNameParts[fileNameParts.length - 1];

        switch (fileType) {
            case TASK_FILE_TYPE_JSON: {
                return new JsonTaskParser();
            }

            default:
                throw new Exception("暂时不支持此类型的文件：" + fileType);
        }

    }

}
