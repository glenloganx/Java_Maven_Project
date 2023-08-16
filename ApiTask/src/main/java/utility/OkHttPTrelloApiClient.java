package utility;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.BeforeTest;
import java.io.IOException;

public class OkHttPTrelloApiClient {
    protected static OkHttpClient okHttpClient;
    @BeforeTest
    public static void setUp() {
        okHttpClient = new OkHttpClient();
    }

    public int delete(String boardId) throws IOException {
        //Deleting board after test
        Request deleteRequest = BuildOkHttpRequest.DELETE(boardId);
        Response deleteResponse = okHttpClient.newCall(deleteRequest).execute();
        return deleteResponse.code();
    }
}
