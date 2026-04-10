package com.xjy.week02.entity;

public enum Gender {
    MALE("男"),
    FEMALE("女");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
