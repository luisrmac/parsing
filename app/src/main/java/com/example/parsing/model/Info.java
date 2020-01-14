package com.example.parsing.model;

public class Info {

    public static final String SERIALIZED_NAME_SEED = "seed";
    public static final String SERIALIZED_NAME_RESULTS = "results";
    public static final String SERIALIZED_NAME_PAGE = "page";
    public static final String SERIALIZED_NAME_VERSION = "version";

    private String seed;
    private int results;
    private int page;
    private String version;

    public Info() {

    }

    public Info(String seed, int results, int page, String version) {
        this.seed = seed;
        this.results = results;
        this.page = page;
        this.version = version;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Info{" +
                "seed='" + seed + '\'' +
                ", results=" + results +
                ", page=" + page +
                ", version='" + version + '\'' +
                '}';
    }
}
