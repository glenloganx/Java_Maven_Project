package OkHTTP;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.Board;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BuildOkHttpRequest;
import utility.OkHttPTrelloApiClient;

public class CreateBoardTest extends OkHttPTrelloApiClient {
    @SneakyThrows
    @Test
    public void test() {
            String name = "OkhttpTestBoard";
            Request request =BuildOkHttpRequest.POST(name);;
           
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            String json = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            Board board = mapper.readValue(json, Board.class);

            Assert.assertEquals(response.code(),200);
            //Deleting board from trello after use
           Assert.assertEquals(delete(board.getId()),200);

    }
}
