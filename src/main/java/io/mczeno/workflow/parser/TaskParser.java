package io.mczeno.workflow.parser;

import io.mczeno.workflow.Task;

import java.io.File;
import java.util.List;

/**
 * TaskParser
 *
 * @author Chongming Zhou
 */
public interface TaskParser {

    /**
     * 解析任务
     *
     * @param file 任务文件
     * @return 任务数据
     * @throws Exception 解析任务时可能有异常
     */
    List<Task> parseTasks(File file) throws Exception;

}
