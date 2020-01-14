package com.example.parsing.model;

public class Name {

    public static final String SERIALIZED_NAME_TITLE = "title";
    public static final String SERIALIZED_NAME_FIRST = "first";
    public static final String SERIALIZED_NAME_LAST = "last";

    private String title;
    private String first;
    private String last;

    public Name() {
    }

    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Name{" +
                "title='" + title + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
