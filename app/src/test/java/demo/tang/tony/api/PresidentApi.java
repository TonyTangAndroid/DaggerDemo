package demo.tang.tony.api;

import demo.tang.tony.model.President;
import demo.tang.tony.model.Teacher;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PresidentApi {
    @GET("{request_id}")
    Call<President> get(@Path("request_id") String id);
}