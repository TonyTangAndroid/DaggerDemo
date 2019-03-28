package demo.tang.tony.com.daggerdemo;

import demo.tang.tony.model.Teacher;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeacherApi {
    @GET("{request_id}")
    Call<Teacher> get(@Path("request_id") String id);
}