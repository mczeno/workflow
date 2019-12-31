package io.mczeno.workflow.parser;

import io.mczeno.workflow.constant.TaskConfigurationTypeEnum;

import java.lang.reflect.Constructor;

/**
 * TaskParserFactory
 *
 * @author Chongming Zhou
 */
public class TaskParserFactory {

    /**
     * 通过输入的文件类型判断并获取任务解析器
     */
    public TaskParser getTaskParser(String fileType) {
        TaskConfigurationTypeEnum taskConfigTypeEnum;
        try {
            taskConfigTypeEnum = TaskConfigurationTypeEnum.valueOf(fileType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("暂时不支持此类型的任务文件：" + fileType);
        }

        try {
            Class<?> clazz = Class.forName(taskConfigTypeEnum.getParserClassName());
            Constructor<?> constructor = clazz.getConstructor();
            return (TaskParser) constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("获取任务解析器异常", e);
        }
    }

}
