package tewodros.com.example.trackcovid19;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ICovid19Service {

    @GET("v1/global/count")
    Call<ResponseBody> getHistoryDataForGlobal();


}
