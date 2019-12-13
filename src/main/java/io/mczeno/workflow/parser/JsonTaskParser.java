package io.mczeno.workflow.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.mczeno.workflow.Task;

import java.io.File;
import java.io.IOException;

/**
 * JsonTaskParser
 *
 * @author Chongming Zhou
 */
public class JsonTaskParser implements TaskParser {

    private ObjectMapper objectMapper;

    public JsonTaskParser() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Task[] parseTasks(File file) throws IOException {
        return objectMapper.readValue(file, Task[].class);
    }

}
