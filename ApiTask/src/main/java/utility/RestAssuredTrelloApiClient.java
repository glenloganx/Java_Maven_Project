package utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class RestAssuredTrelloApiClient {
    protected static RequestSpecification requestSpec;

    @BeforeClass
    public static void setBaseUri() {
        requestSpec = new RequestSpecBuilder().setBaseUri(TrelloConstants.BASE_URI).build();
    }

    
       
    
}
