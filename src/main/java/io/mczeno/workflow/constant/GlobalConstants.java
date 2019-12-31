package io.mczeno.workflow.constant;

/**
 * GlobalConstants
 *
 * @author Chongming Zhou
 */
public interface GlobalConstants {

    String DEFAULT_TASK_FILE_NAME = "workflow_task";
    String TASK_FILE_TYPE_JSON = "json";
    String FILE_SEPARATOR = ".";
    String FILE_SEPARATOR_REGEX = "\\.";
    String TASK_PARSER_PACKAGE_PREFIX = "io.mczeno.workflow.parser.";

    String DEFAULT_JSON_TASK_FILE_NAME = DEFAULT_TASK_FILE_NAME + FILE_SEPARATOR + TASK_FILE_TYPE_JSON;

}
