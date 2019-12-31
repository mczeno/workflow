package io.mczeno.workflow.constant;

import static io.mczeno.workflow.constant.GlobalConstants.TASK_PARSER_PACKAGE_PREFIX;

/**
 * TaskConfigurationTypeEnum
 *
 * @author Chongming Zhou
 */
public enum TaskConfigurationTypeEnum {

    // json 解析
    JSON("JsonTaskParser"),
    ;

    private String parserClassName;


    TaskConfigurationTypeEnum(String parserClassName) {
        this.parserClassName = parserClassName;
    }

    public String getParserClassName() {
        return TASK_PARSER_PACKAGE_PREFIX + parserClassName;
    }

    public void setParserClassName(String parserClassName) {
        this.parserClassName = parserClassName;
    }

}
