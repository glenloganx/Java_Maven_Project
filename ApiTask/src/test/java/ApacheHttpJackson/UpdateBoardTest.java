package ApacheHttpJackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import utility.ApacheHttpTrelloApiClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BuildApacheHttpRequest;
import utility.ApacheHttpResponseHandler;

import java.io.IOException;
import static utility.BuildApacheHttpRequest.getApacheHttpPutRequest;

public class UpdateBoardTest extends ApacheHttpTrelloApiClient {
    @Test
    public void testUpdateBoardNameGivenId(){
        try{
            HttpPost createBoardToUpdate = BuildApacheHttpRequest.getApacheHttpPostRequest("TestUpdateBoard");
            String responseJson = EntityUtils.toString(new ApacheHttpResponseHandler(
                    apacheHttpClient.execute(createBoardToUpdate)).getEntity()
            );
            ObjectMapper mapper = new ObjectMapper();
            Board board = mapper.readValue(responseJson, Board.class);
            String boardId = board.getId();

            String newName = "UpdateNameTest";
            HttpPut updateBoard = getApacheHttpPutRequest(boardId,newName);
            CloseableHttpResponse response = apacheHttpClient.execute(updateBoard);

            int responseCode = response.getStatusLine().getStatusCode();
            Assert.assertEquals(responseCode,200);

            //delete board from trello after use
//            Assert.assertEquals(delete(board.getId()), 200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
