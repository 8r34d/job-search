package spencer.dean.jobsearch;

public enum Pages {

    HOME(""),
    RESULTS("JobSearch/Results.aspx");

    private final String url;

    Pages(String url) {
        this.url = url;
    }

    public String url() { return url; }
}