package OkHTTP;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.OkHttPTrelloApiClient;
import utility.BuildOkHttpRequest;
import java.io.IOException;

public class DeleteBoardTest extends OkHttPTrelloApiClient {
    @Test
    public void test() {
        try {
            String name = "OkhttpTest";
    
            Request request = BuildOkHttpRequest.POST(name);;
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            String json = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            Board board = mapper.readValue(json, Board.class);

            String boardId = board.getId();
            Request  deleteRequest = BuildOkHttpRequest.DELETE(boardId);
            Response   deleteResponse = okHttpClient.newCall(deleteRequest).execute();
            Assert.assertEquals(deleteResponse.code(),200);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
