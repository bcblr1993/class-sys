package com.baizhi.vos;

/**
 * @author chenyn
 * @since 1.0
 */
public class TagTypeVO {
    private Integer value;
    private String name;

    public TagTypeVO() {
    }

    public TagTypeVO(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
