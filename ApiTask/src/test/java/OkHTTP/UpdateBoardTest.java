package OkHTTP;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.OkHttPTrelloApiClient;
import utility.BuildOkHttpRequest;
import utility.JsonToPojo;

import java.io.IOException;

public class UpdateBoardTest extends OkHttPTrelloApiClient {
    @Test
    public void test() {
        try {
            String name = "OkhttpTest";
            Request request = BuildOkHttpRequest.POST(name);
            Response response = okHttpClient.newCall(request).execute();

            Assertions.assertNotNull(response);
            String responseJson = response.body().string();
         
            Board board = JsonToPojo.JSONToBoard(responseJson);
            String newName = "OkhttpUpdaterTest";

            Request updateBoard = BuildOkHttpRequest.PUT(board.getId(), newName);
            Response updateResponse = okHttpClient.newCall(updateBoard).execute();

            Assert.assertEquals(updateResponse.code(), 200);
            Assert.assertEquals(delete(board.getId()), 200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
