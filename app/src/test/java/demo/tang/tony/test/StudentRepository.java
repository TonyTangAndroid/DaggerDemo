package demo.tang.tony.test;

import java.io.IOException;

import demo.tang.tony.api.RestApi;
import demo.tang.tony.model.Student;
import retrofit2.Call;
import retrofit2.Response;


public class StudentRepository {
    private final RestApi restApi;

    public StudentRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    public Student get(String id) throws IOException {
        Call<Student> personCall = restApi.get(id);
        Response<Student> response = personCall.execute();
        return response.body();
    }

}