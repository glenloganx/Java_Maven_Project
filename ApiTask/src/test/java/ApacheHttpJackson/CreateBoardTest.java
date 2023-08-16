package ApacheHttpJackson;

import io.qameta.allure.Step;
import utility.ApacheHttpResponseHandler;
import utility.ApacheHttpTrelloApiClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static utility.BuildApacheHttpRequest.getApacheHttpPostRequest;

public class CreateBoardTest extends ApacheHttpTrelloApiClient {

  @Step
  @Test(priority = 1, description = "Create a new board and verify the response code is 200")
  public void testSuccessResponseCode() {
    try {
      String name = "TestCreateBoard_2023";
      //Build the request
      HttpPost post = getApacheHttpPostRequest(name);

      // send the request
      ApacheHttpResponseHandler responseHandler = new ApacheHttpResponseHandler(apacheHttpClient.execute(post));
      int responseCode = responseHandler.getresponseCode();
//      HttpEntity entity = responseHandler.getEntity();

      Assert.assertEquals(responseCode, 200, "Response code 400(free board limit exceeded)");
//      Assert.assertEquals(responseCode, 200, "Board not deleted after test");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

//    @Test(priority = 2, description = "Verify board created successfully")
//    public void testJsonResponseToBoardPojo() {
//        try {
//            String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
//            ObjectMapper mapper = new ObjectMapper();
//            Board board = mapper.readValue(json, Board.class);
//
//            //delete board from trello after use
//            Assert.assertEquals(delete(board.getId()), 200);
//            Assert.assertNotNull(board);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test(priority = 3, description = "Create a bad http request and verify error response code is 400")
//    public void testErrorResponseCode() {
//        try {
//            String name = "&TtBoard";
//            HttpPost post = getPostRequest(name);
//            // send the request
//            ApacheHttpResponseHandler response = new ApacheHttpResponseHandler(apacheHttpClient.execute(post));
//            entity = response.getEntity();
//            int responseCode = response.getresponseCode();
//
//            Assert.assertEquals(responseCode, 400);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
