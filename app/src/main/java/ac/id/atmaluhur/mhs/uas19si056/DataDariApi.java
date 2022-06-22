package ac.id.atmaluhur.mhs.uas19si056;

import java.util.List;
import retrofit2.http.GET;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.QueryMap;
public interface DataDariApi {
    @GET("dosen.php")
    Call<List<DosenPost>> getPosts(

    );
    @GET("dosen.php")
    Call<List<DosenPost>> getPosts(@QueryMap Map<String,String> parameters);
}
