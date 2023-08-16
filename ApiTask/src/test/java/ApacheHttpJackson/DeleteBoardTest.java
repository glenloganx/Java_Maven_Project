package ApacheHttpJackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import utility.ApacheHttpResponseHandler;
import utility.ApacheHttpTrelloApiClient;
import org.apache.http.client.methods.HttpDelete;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BuildApacheHttpRequest;
import java.io.IOException;

public class DeleteBoardTest extends ApacheHttpTrelloApiClient {
    @Test
    public void testDeleteBoardByID_ResponseCodeEql200() {
        try {
            HttpPost createBoardToDelete = BuildApacheHttpRequest.getApacheHttpPostRequest("TestDeleteBoard");
            String json = EntityUtils.toString(new ApacheHttpResponseHandler(
                    apacheHttpClient.execute(createBoardToDelete)).getEntity()
            );
            ObjectMapper mapper = new ObjectMapper();
            Board board = mapper.readValue(json, Board.class);
            String boardId = board.getId();
            HttpDelete delete = BuildApacheHttpRequest.getApacheHttpDeleteRequest(boardId);
            ApacheHttpResponseHandler response = new ApacheHttpResponseHandler(apacheHttpClient.execute(delete));
            int responseCode = response.getresponseCode();
            Assert.assertEquals(responseCode, 200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
