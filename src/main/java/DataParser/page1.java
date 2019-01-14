package DataParser;

import com.fasterxml.jackson.annotation.JsonProperty;

public class page1 {
    @JsonProperty("url")
    private String url;

    @JsonProperty("page_header")
    private String page_header;

    @JsonProperty("button_name")
    private String button_name;

    @JsonProperty("logo_name")
    private String logo_name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPage_header() {
        return page_header;
    }

    public void setPage_header(String page_header) {
        this.page_header = page_header;
    }

    public String getButton_name() {
        return button_name;
    }

    public void setButton_name(String button_name) {
        this.button_name = button_name;
    }

    public String getLogo_name() {
        return logo_name;
    }

    public void setLogo_name(String logo_name) {
        this.logo_name = logo_name;
    }
}
