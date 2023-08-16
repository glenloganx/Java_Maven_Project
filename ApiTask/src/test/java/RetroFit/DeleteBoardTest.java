package RetroFit;

import java.io.IOException;

import models.Board;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import utility.RetroFitTrelloApiService;
import utility.RetroFitTrelloApiServiceGenerator;
import utility.TrelloConstants;

public class DeleteBoardTest {
    @Test
    public void test() {
        try {
        String name = "RetorFitToDelete";
        RetroFitTrelloApiService trelloApi =  RetroFitTrelloApiServiceGenerator.createTrelloApiService(RetroFitTrelloApiService.class);
        Call<Board> call = trelloApi.createBoard(name, TrelloConstants.API_KEY, TrelloConstants.API_TOKEN);
        Response<Board> response = call.execute();

        String id = "64c7eb2f9b2689bf5da1c838";
        Call<ResponseBody> deletCall = trelloApi.deleteBoard(id,TrelloConstants.API_KEY, TrelloConstants.API_TOKEN);
        Response<ResponseBody> deleteResponse = deletCall.execute();
        Assert.assertTrue(deleteResponse.isSuccessful());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
