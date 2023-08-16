package utility;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitTrelloApiServiceGenerator {
    private RetroFitTrelloApiServiceGenerator(){
        throw new IllegalStateException("Utility class");
    }
    private static final Retrofit RETROFIT = new Retrofit.Builder()
        .baseUrl(TrelloConstants.BASE_URI)
        .addConverterFactory(GsonConverterFactory.create()).build();

    public static <S> S createTrelloApiService(Class<S> serviceClass) {
        return RETROFIT.create(serviceClass);
    }
}
