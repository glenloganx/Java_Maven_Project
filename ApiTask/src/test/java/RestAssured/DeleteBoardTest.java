package RestAssured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.RestAssuredRequestBuilder;
import utility.RestAssuredTrelloApiClient;

public class DeleteBoardTest extends RestAssuredTrelloApiClient {
    @Test
    public void deleteBoard(){
        //Creating board to delete
        String name = "RestAssuredTestDelete";
        Response createBoardResponse = RestAssuredRequestBuilder.POST(name);
        String boardId = createBoardResponse.jsonPath().get("id").toString();

        //Sending delete request
        Response deleteBoardResponse = RestAssuredRequestBuilder.DELETE(boardId);    
        Assert.assertEquals(deleteBoardResponse.getStatusCode(),200);
    }
}
