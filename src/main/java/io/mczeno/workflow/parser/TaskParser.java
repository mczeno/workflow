package io.mczeno.workflow.parser;

import io.mczeno.workflow.Task;

import java.io.File;

/**
 * TaskParser
 *
 * @author Chongming Zhou
 */
public interface TaskParser {

    Task[] parseTasks(File file) throws Exception;

}
