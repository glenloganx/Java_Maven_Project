package utility;

import models.Board;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroFitTrelloApiService {
    String QUERY_KEY = "key";
    String QUERY_TOKEN = "token";
    String PATH_ID = "id";
    String QUERY_NAME = "name";
    @POST(" ")
    Call<Board> createBoard(@Query(QUERY_NAME) String name,
            @Query(QUERY_KEY) String key,
            @Query(QUERY_TOKEN) String token
    );

    @GET("{id}")
    Call<Board> getBoard(@Path(PATH_ID ) String id,
            @Query(QUERY_KEY) String key,
            @Query(QUERY_TOKEN) String token
    );

    @DELETE("{id}")
    Call<ResponseBody> deleteBoard(@Path(PATH_ID ) String id,
            @Query(QUERY_KEY) String key,
            @Query(QUERY_TOKEN) String token
    );

    @PUT("{id}")
    Call<ResponseBody> updateBoard(@Path(PATH_ID ) String id,
            @Query(QUERY_NAME) String name,
            @Query(QUERY_KEY) String key,
            @Query(QUERY_TOKEN) String token
    );
}
