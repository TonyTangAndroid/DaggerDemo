package demo.tang.tony.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.api.StudentApi;
import demo.tang.tony.di.network.DaggerNetworkComponent;
import demo.tang.tony.model.Student;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;


public class PersonTest {

    private StudentApi studentApi;

    private MockWebServer mockWebServer;


    @Before
    public void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        studentApi = DaggerNetworkComponent.builder().url(mockWebServer.url("/").toString()).build().studentApi();
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }


    @Test
    public void addition_isCorrect() throws IOException {
        assertEquals(expected(), actual2());
    }

    private Student actual2() throws IOException {

        String json = TestUtils.json("student.json", this);
        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody(json);
        mockWebServer.enqueue(mockResponse);


        Call<Student> personCall = studentApi.get("5c9302e0320000e51c6bd167");
        Response<Student> response = personCall.execute();
        return response.body();
    }


    private Student expected() {
        return Student.builder().name("tony").build();
    }
}