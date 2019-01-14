package ee.arvato;

import DataParser.DataParser;
import DataParser.WebPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class afsTestWorkPart1Test extends Base {

    private WebPage pages;
    private String jsonFile;

    public afsTestWorkPart1Test(String jsonFiles){
        this.jsonFile = jsonFiles;
    }

    @Parameterized.Parameters
    public static Collection<Object[] > data(){
        Object[][] data = new Object[][] { {"en.json"}, {"ee.json"}};
        return Arrays.asList(data);
    }

    @Before
    public void setUpSuite() {
        pages = DataParser.get(jsonFile, WebPage.class);
    }

    @Test
    public void testCreateTask() throws Exception {

        //Go to "CRM & Customer Services"
        openPageFromUrl(pages.getCrmCustomerService().getUrl());

        //Check that logo,header and button are ok on "CRM & Customer Services"
        checkCrmCustomerServicePage(pages.getCrmCustomerService().getLogo_name(),pages.getCrmCustomerService().getPage_header(),pages.getCrmCustomerService().getButton_name());

        //Go to "CRM Open positions" page
        openPageFromUrl(pages.getOpenPositions().getUrl());

        //Check that header and positions are ok on "CRM Open positions" page
        checkCrmOpenPositionsPage(pages.getOpenPositions().getPositions().size(), pages.getOpenPositions().getPositions(), pages.getOpenPositions().getPage_header());
    }
}
