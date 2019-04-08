package demo.tang.tony.api;

import demo.tang.tony.model.Student;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StudentApi {

    @GET("{request_id}")
    Call<Student> get(@Path("request_id") String id);

}