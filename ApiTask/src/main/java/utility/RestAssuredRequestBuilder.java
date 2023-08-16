package utility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class RestAssuredRequestBuilder extends RestAssuredTrelloApiClient {

    public static Response POST(String name){
        return  given().spec(requestSpec).queryParam("name",name).
        queryParam("key",TrelloConstants.API_KEY)
        .queryParam("token",TrelloConstants.API_TOKEN).contentType(ContentType.JSON).post();
    }

    public static Response PUT(String boardId,String newName){
       return given().spec(requestSpec)
            .queryParam("name",newName)
            .pathParam("id", boardId)
            .queryParam("key",TrelloConstants.API_KEY)
            .queryParam("token",TrelloConstants.API_TOKEN)
            .contentType(ContentType.JSON).put("{id}");
    }


    public static Response DELETE(String boardId){
        return given().spec(requestSpec)
              .pathParam("id",boardId)
              .queryParam("key",TrelloConstants.API_KEY)
              .queryParam("token",TrelloConstants.API_TOKEN)
              .contentType(ContentType.JSON).delete("{id}");
    }

      public static Response GET(String boardId){
        return given().spec(requestSpec)
              .pathParam("id",boardId)
              .queryParam("key",TrelloConstants.API_KEY)
              .queryParam("token",TrelloConstants.API_TOKEN).contentType(ContentType.JSON).get("{id}");
}
}
