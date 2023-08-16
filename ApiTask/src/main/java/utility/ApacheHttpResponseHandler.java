package utility;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import java.io.IOException;

public class ApacheHttpResponseHandler {
    private final CloseableHttpResponse response;

    public ApacheHttpResponseHandler(CloseableHttpResponse response) {
        this.response = response;
    }

    public int getresponseCode() {
        return response.getStatusLine().getStatusCode();
    }

    public HttpEntity getEntity() {
        return response.getEntity();
    }

    public void close() throws IOException {
        response.close();
    }
}
