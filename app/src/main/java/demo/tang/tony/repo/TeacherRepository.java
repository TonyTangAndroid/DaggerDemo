package demo.tang.tony.repo;

import java.io.IOException;

import javax.inject.Inject;

import demo.tang.tony.api.TeacherApi;
import demo.tang.tony.model.Teacher;
import retrofit2.Call;
import retrofit2.Response;


public class TeacherRepository {
    private final TeacherApi restApi;

    @Inject
    public TeacherRepository(TeacherApi restApi) {
        this.restApi = restApi;
    }

    public Teacher get(String id) throws IOException {
        Call<Teacher> personCall = restApi.get(id);
        Response<Teacher> response = personCall.execute();
        return response.body();
    }

}