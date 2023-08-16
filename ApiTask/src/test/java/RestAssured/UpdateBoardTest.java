package RestAssured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.RestAssuredRequestBuilder;
import utility.RestAssuredTrelloApiClient;

public class UpdateBoardTest extends RestAssuredTrelloApiClient {
    @Test
    public void updateBoard(){
        //Creating board to be updated
        String name = "RestUpdateTestOMG";
        Response createBoardResponse = RestAssuredRequestBuilder.POST(name);
        Assert.assertEquals(createBoardResponse.getStatusCode(),200);

        String boardId = createBoardResponse.jsonPath().get("id").toString(); 
        String newName = "BoardUpdatedFromRestAssured";
       
        //Sending update request
        Response updateResponse = RestAssuredRequestBuilder.PUT(boardId, newName);
        Assert.assertEquals(updateResponse.getStatusCode(),200);
        Assert.assertEquals(newName, updateResponse.jsonPath().get("name").toString());
        
        //Deleting board after test
        Response deleteBoardResponse = RestAssuredRequestBuilder.DELETE(boardId);
        Assert.assertEquals(deleteBoardResponse.getStatusCode(),200);
    }
}

