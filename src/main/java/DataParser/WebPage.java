package DataParser;


import com.fasterxml.jackson.annotation.JsonProperty;

public class WebPage {
    @JsonProperty("page1")
    private page1 crmCustomerService;

    @JsonProperty("page2")
    private page2 openPositions;

    public page1 getCrmCustomerService() {
        return crmCustomerService;
    }

    public void setCrmCustomerService(page1 crmCustomerService) {
        this.crmCustomerService = crmCustomerService;
    }

    public page2 getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(page2 openPositions) {
        this.openPositions = openPositions;
    }
}
