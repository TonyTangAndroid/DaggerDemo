package demo.tang.tony.com.test;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.com.daggerdemo.DaggerNetworkComponent;
import demo.tang.tony.api.RestApi;
import demo.tang.tony.model.Student;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;


public class PersonTest {


    public static final String SERVER_URL = "http://www.mocky.io/v2/";

    private RestApi restApi;

    @Before
    public void setup() {
        restApi = DaggerNetworkComponent.builder().url(SERVER_URL).build().restApi();
    }

    @Test
    public void addition_isCorrect() throws IOException {
        assertEquals(expected(), actual2());
    }

    private Student actual2() throws IOException {

        Call<Student> personCall = restApi.get("5c9302e0320000e51c6bd167");
        Response<Student> response = personCall.execute();
        return response.body();
    }


    private Student expected() {
        return Student.builder().name("tony").build();
    }
}