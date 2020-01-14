package com.example.parsing.model;

public class Result {

    public static final String SERIALIZED_NAME_GENDER = "gender";
    public static final String SERIALIZED_NAME_NAME = "name";

    private String gender;
    private Name name;

    public Result() {
    }

    public Result(String gender, Name name) {
        this.gender = gender;
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Result{" +
                "gender='" + gender + '\'' +
                ", name=" + name +
                '}';
    }
}
