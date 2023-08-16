package utility;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Objects;

public final class BuildOkHttpRequest {
    static RequestBody body = RequestBody.create(null, new byte[0]);
    private BuildOkHttpRequest(){
        throw new IllegalStateException("Utility class");
    }

    public static Request POST(String name){
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(
            HttpUrl.parse(String.format("%s?name=%s&key=%s&token=%s",
            TrelloConstants.BASE_URI, name,TrelloConstants.API_KEY,
            TrelloConstants.API_TOKEN))).newBuilder();
        return new Request.Builder().url(urlBuilder.build().toString()).post(body).build();
    }
    public static Request DELETE(String id){
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(String.format("%s%s?key=%s&token=%s",
                        TrelloConstants.BASE_URI, id, TrelloConstants.API_KEY,
                        TrelloConstants.API_TOKEN))).newBuilder();
                        return new Request.Builder().url(urlBuilder.build().toString()).post(body).build();
    }

    public static Request GET(String id){
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(String.format
                ("%s%s?key=%s&token=%s",
                        TrelloConstants.BASE_URI, id, TrelloConstants.API_KEY, TrelloConstants.API_TOKEN
                ))).newBuilder();
                return new Request.Builder().url(urlBuilder.build().toString()).post(body).build();
    }

    public static Request PUT(String id,String name){
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(String.format("%s%s?name=%s&key=%s&token=%s",
                TrelloConstants.BASE_URI, id, name, TrelloConstants.API_KEY, TrelloConstants.API_TOKEN
        ))).newBuilder();
        return new Request.Builder().url(urlBuilder.build().toString()).post(body).build();
    }
}
