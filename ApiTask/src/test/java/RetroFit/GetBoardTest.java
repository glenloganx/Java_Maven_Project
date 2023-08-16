package RetroFit;

import java.io.IOException;
import org.testng.annotations.Test;
import models.Board;
import retrofit2.Call;
import retrofit2.Response;
import utility.RetroFitTrelloApiService;
import utility.RetroFitTrelloApiServiceGenerator;
import utility.TrelloConstants;

public class GetBoardTest {
    @Test
    public void test() {
        try {
        String id = "64c7eb2f9b2689bf5da1c838";
        RetroFitTrelloApiService trelloApi =  RetroFitTrelloApiServiceGenerator.createTrelloApiService(RetroFitTrelloApiService.class);;
        Call<Board> call = trelloApi.getBoard
        (id, TrelloConstants.API_KEY, TrelloConstants.API_TOKEN);
            Response<Board> response = call.execute();
        
            if (response.isSuccessful()) {
                // handle success
                Board board = response.body();
                System.out.println(board.getName()+"\n"+board.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
