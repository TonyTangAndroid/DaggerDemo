package demo.tang.tony.com.daggerdemo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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

        Call<Student> personCall = restApi.get("5c9319653200009d626bd1c7");
        Response<Student> response = personCall.execute();
        return response.body();
    }


    private Student expected() {
        NestName nested = NestName.builder().name("tony").build();
        return Student.builder().name(nested).build();
    }
}