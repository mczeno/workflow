package io.mczeno.workflow;

import io.mczeno.workflow.constant.TaskCategoryEnum;

import java.util.StringJoiner;

/**
 * Task
 *
 * @author Chongming Zhou
 */
public class Task {

    private String id;
    private String name;
    private Integer cycles = 1;
    private TaskCategoryEnum category;
    private Object content;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCycles() {
        return cycles;
    }

    public void setCycles(Integer cycles) {
        this.cycles = cycles;
    }

    public TaskCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(TaskCategoryEnum category) {
        this.category = category;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Task.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("cycles=" + cycles)
                .add("category=" + category)
                .add("content=" + content)
                .toString();
    }

}
