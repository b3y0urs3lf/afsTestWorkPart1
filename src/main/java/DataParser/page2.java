package DataParser;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class page2 {
    @JsonProperty("url")
    private String url;

    @JsonProperty("page_header")
    private String page_header;

    @JsonProperty("positions")
    private List<String> positions;

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

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }
}
