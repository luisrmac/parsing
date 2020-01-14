package com.example.parsing.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RandomResponse {

    public static final String SERIALIZED_NAME_RESULTS = "results";
    public static final String SERIALIZED_NAME_INFO = "info";

    private ArrayList<Result> results;
    private Info info;

    public RandomResponse() {
    }

    public RandomResponse(ArrayList<Result> results, Info info) {
        this.results = results;
        this.info = info;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "RandomResponse{" +
                "results=" + results +
                ", info=" + info +
                '}';
    }


}
