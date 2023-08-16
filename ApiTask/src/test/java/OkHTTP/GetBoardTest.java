package OkHTTP;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.OkHttPTrelloApiClient;
import utility.BuildOkHttpRequest;
import java.io.IOException;

public class GetBoardTest extends OkHttPTrelloApiClient {
    @Test
    public void test() {
        try {
            String name= "CreateBoardToRetrieve";
            Request createBoardRequest = BuildOkHttpRequest.POST(name);
            Response response = okHttpClient.newCall(createBoardRequest).execute();

            ObjectMapper mapper = new ObjectMapper();
            Board board = mapper.readValue(response.body().string(), Board.class);

            Request getBoardRequest = BuildOkHttpRequest.GET(board.getId());
            Response getResponse = okHttpClient.newCall(getBoardRequest).execute();

            Assert.assertEquals(getResponse.code(),200);
            Assert.assertEquals(delete(board.getId()),200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
