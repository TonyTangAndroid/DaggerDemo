package demo.tang.tony.com.daggerdemo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.model.Teacher;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;


public class TeacherTest {


    public static final String SERVER_URL = "http://www.mocky.io/v2/";

    private TeacherApi teacherApi;

    @Before
    public void setup() {
        teacherApi = DaggerNetworkComponent.builder().url(SERVER_URL).build().teacherApi();
    }

    @Test
    public void addition_isCorrect() throws IOException {
        assertEquals(expected(), actual2());
    }

    private Teacher actual2() throws IOException {

        Call<Teacher> personCall = teacherApi.get("5c9302e0320000e51c6bd167");
        Response<Teacher> response = personCall.execute();
        return response.body();
    }


    private Teacher expected() {
        return Teacher.builder().name("tony").build();
    }
}