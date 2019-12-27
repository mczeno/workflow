package io.mczeno.workflow.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.mczeno.workflow.Task;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
    public List<Task> parseTasks(File file) throws IOException {
        return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
    }

}
