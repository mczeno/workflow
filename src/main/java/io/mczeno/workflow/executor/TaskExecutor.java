package io.mczeno.workflow.executor;

import io.mczeno.workflow.Task;

import java.util.List;

/**
 * TaskExecutor
 *
 * @author Chongming Zhou
 */
public interface TaskExecutor {

    /**
     * 执行任务
     * @param tasks 任务列表
     */
    void execute(List<Task> tasks);

}
