package RestAssured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.RestAssuredRequestBuilder;
import utility.RestAssuredTrelloApiClient;

public class GetBoardTest extends RestAssuredTrelloApiClient {
    @Test
    public void getBoard(){
        //Creating board for retrieval
        String name = "RestAssuredTestGetBoard";
        Response createBoardResponse = RestAssuredRequestBuilder.POST(name);
        String boardId = createBoardResponse.jsonPath().get("id").toString();

        //Sending get request
        Response response = RestAssuredRequestBuilder.GET(boardId);
        Assert.assertEquals(response.getStatusCode(),200);

        //Deleting board after test
        Response deleteBoardResponse = RestAssuredRequestBuilder.DELETE(boardId);
        Assert.assertEquals(deleteBoardResponse.getStatusCode(),200);
    }
}
