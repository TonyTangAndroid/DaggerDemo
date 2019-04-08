package demo.tang.tony.repo;

import java.io.IOException;

import javax.inject.Inject;

import demo.tang.tony.api.StudentApi;
import demo.tang.tony.model.Student;
import retrofit2.Call;
import retrofit2.Response;


public class StudentRepository {
    private final StudentApi restApi;

    @Inject
    public StudentRepository(StudentApi restApi) {
        this.restApi = restApi;
    }

    public Student get(String id) throws IOException {
        Call<Student> personCall = restApi.get(id);
        Response<Student> response = personCall.execute();
        return response.body();
    }

}