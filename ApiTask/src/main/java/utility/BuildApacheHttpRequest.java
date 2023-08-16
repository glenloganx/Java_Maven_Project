package utility;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;


public final class BuildApacheHttpRequest {
    private BuildApacheHttpRequest(){
        throw new IllegalStateException("Utility class");
    }
    public static HttpPost getApacheHttpPostRequest(String name) {
        return new HttpPost(String.format("%s?name=%s&key=%s&token=%s",
                TrelloConstants.BASE_URI,name, TrelloConstants.API_KEY, TrelloConstants.API_TOKEN));
    }

    public static HttpPut getApacheHttpPutRequest(String id, String name){
        return new HttpPut(String.format("%s%s?name=%s&key=%s&token=%s",
                TrelloConstants.BASE_URI,id,name,TrelloConstants.API_KEY,TrelloConstants.API_TOKEN
        ));
    }

    public static HttpDelete getApacheHttpDeleteRequest(String id){
        return new HttpDelete(String.format("%s%s/?key=%s&token=%s",
                TrelloConstants.BASE_URI,id,TrelloConstants.API_KEY,TrelloConstants.API_TOKEN));
    }

    public static HttpGet getApacheHttpGetRequest(String id){
        return new HttpGet(String.format("%s%s?key=%s&token=%s",
                TrelloConstants.BASE_URI,id,TrelloConstants.API_KEY,TrelloConstants.API_TOKEN));
    }

    

}
