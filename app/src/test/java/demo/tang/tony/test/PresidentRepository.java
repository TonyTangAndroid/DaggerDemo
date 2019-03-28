package demo.tang.tony.test;

import java.io.IOException;

import javax.inject.Inject;

import demo.tang.tony.api.PresidentApi;
import demo.tang.tony.model.President;
import demo.tang.tony.model.Teacher;
import retrofit2.Call;
import retrofit2.Response;


public class PresidentRepository {
    private final PresidentApi presidentApi;

    @Inject
    public PresidentRepository(PresidentApi presidentApi) {
        this.presidentApi = presidentApi;
    }

    public President get(String id) throws IOException {
        Call<President> personCall = presidentApi.get(id);
        Response<President> response = personCall.execute();
        return response.body();
    }

}