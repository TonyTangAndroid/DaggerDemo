package demo.tang.tony.test;

import com.google.common.truth.Truth;

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


public class MockStudentTest {

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
    public void test_mock() throws IOException {

        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody("{\"name\":\"Tony\"}");
        mockWebServer.enqueue(mockResponse);
        Call<Student> personCall = studentApi.get("5c9302e0320000e51c6bd167");
        retrofit2.Response<Student> response = personCall.execute();
        Truth.assertThat(response.body()).isEqualTo(expected());
    }

    private Student expected() {
        return Student.builder().name("Tony").build();
    }

}