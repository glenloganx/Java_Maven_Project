package RetroFit;

import java.io.IOException;

import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;
import okhttp3.ResponseBody;
import retrofit2.Call;
import utility.RetroFitTrelloApiService;
import utility.RetroFitTrelloApiServiceGenerator;
import utility.TrelloConstants;
import retrofit2.Response;

public class CreateBoardTest {
    @Test
    public void test() {
        try {
            String name = "NewBotoDelit";
            RetroFitTrelloApiService trelloApi = RetroFitTrelloApiServiceGenerator.createTrelloApiService(RetroFitTrelloApiService.class);
            Call<Board> call = trelloApi.createBoard(name, TrelloConstants.API_KEY, TrelloConstants.API_TOKEN);
            Response<Board> response = call.execute();
            Assert.assertTrue(response.isSuccessful());
            Board board = response.body();
            Assert.assertNotNull(board);
            String id = board.getId();

            Call<ResponseBody> deleteCall = trelloApi.deleteBoard(id, TrelloConstants.API_KEY, TrelloConstants.API_TOKEN);
            Response<ResponseBody> deleteResponse = deleteCall.execute();
            Assert.assertTrue(deleteResponse.isSuccessful());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
