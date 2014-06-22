package spencer.dean.jobsearch;

public enum Environments {

    CWJOBS("http://www.cwjobs.co.uk/"),
    DEVELOPMENT("http://development/"),
    TESTING("http://testing/"),
    PRODUCTION("http://www.example.com/");

    private final String url;

    Environments(String url) {
        this.url = url;
    }

    public String url() { return url; }
}