package demo.tang.tony.com.daggerdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {
    @GET("{request_id}")
    Call<Person> get(@Path("request_id") String id);
}