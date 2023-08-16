package ApacheHttpJackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import utility.ApacheHttpResponseHandler;
import utility.ApacheHttpTrelloApiClient;
import org.testng.annotations.Test;
import utility.BuildApacheHttpRequest;

import java.io.IOException;

public class GetBoardTest extends ApacheHttpTrelloApiClient {
//    @Test
    public void testGetBoardByID(){
        try {
            HttpPost createBoardToRetrieve = BuildApacheHttpRequest.getApacheHttpPostRequest("TestGetBoard");
            String json = EntityUtils.toString(new ApacheHttpResponseHandler(
                    apacheHttpClient.execute(createBoardToRetrieve)).getEntity()
            );
            ObjectMapper mapper = new ObjectMapper();
            Board board = mapper.readValue(json, Board.class);
            String boardId = board.getId();
            HttpGet getBoard = BuildApacheHttpRequest.getApacheHttpGetRequest(boardId);
            ApacheHttpResponseHandler response = new ApacheHttpResponseHandler(apacheHttpClient.execute(getBoard));

            int responseCode = response.getresponseCode();
            Assert.assertNotNull(board);
            Assert.assertEquals(responseCode, 200);

            //delete board from trello after use
//            Assert.assertEquals(delete(boardId),200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
