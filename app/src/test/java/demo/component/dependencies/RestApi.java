package demo.component.dependencies;

import demo.tang.tony.model.Student;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {

    @GET("{request_id}")
    Call<Student> get(@Path("request_id") String id);
}