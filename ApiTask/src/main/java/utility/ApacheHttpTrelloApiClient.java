package utility;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;

public class ApacheHttpTrelloApiClient {
    protected static CloseableHttpClient apacheHttpClient;
   
    @BeforeTest
    public static void setUp() {
        apacheHttpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD).build()).build();
    }

//    @AfterTest
//    public int delete(String id) throws IOException {
//        //Deleting board after test
//        HttpDelete deleteBoard = BuildApacheHttpRequest.getApacheHttpDeleteRequest(id);
//        ApacheHttpResponseHandler httpResponse = new ApacheHttpResponseHandler(apacheHttpClient.execute(deleteBoard));
//        return httpResponse.getresponseCode();
//    }
}
