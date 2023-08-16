package RestAssured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.RestAssuredRequestBuilder;
import utility.RestAssuredTrelloApiClient;

public class CreateBoardTest extends RestAssuredTrelloApiClient {
    @Test
    public void createBoard(){
        String name = "RestAssuredTestCreate";
        Response createBoardResponse = RestAssuredRequestBuilder.POST(name);
        String boardId = createBoardResponse.jsonPath().get("id").toString();
        String boardName = createBoardResponse.jsonPath().get("name").toString();

        Assert.assertEquals(createBoardResponse.getStatusCode(),200);
        Assert.assertEquals(name, boardName);

        //Deleting board after test
        Response deleteBoardResponse = RestAssuredRequestBuilder.DELETE(boardId);
        Assert.assertEquals(deleteBoardResponse.getStatusCode(),200);
    }
    
}
