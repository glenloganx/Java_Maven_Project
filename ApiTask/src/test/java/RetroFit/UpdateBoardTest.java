package RetroFit;

import java.io.IOException;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Board;
import okhttp3.ResponseBody;
import retrofit2.Call;
import utility.RetroFitTrelloApiService;
import utility.RetroFitTrelloApiServiceGenerator;
import utility.TrelloConstants;
import retrofit2.Response;
;

public class UpdateBoardTest {
    @Test
    public void test() {
        try {
        String id = "64c7eb2f9b2689bf5da1c838";
        String name = "updatedFromRetrofit";
        RetroFitTrelloApiService trelloApi =  RetroFitTrelloApiServiceGenerator.createTrelloApiService(RetroFitTrelloApiService.class);;
        Call<ResponseBody> call = trelloApi.updateBoard
        (id,name, TrelloConstants.API_KEY, TrelloConstants.API_TOKEN);
            Response<ResponseBody> response = call.execute();
        
            if (response.isSuccessful()) {
                // handle success
                ObjectMapper mapper = new ObjectMapper();
                Board board = mapper.readValue(response.body().string(),Board.class);
                System.out.println(board.getName()+"\n"+board.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
