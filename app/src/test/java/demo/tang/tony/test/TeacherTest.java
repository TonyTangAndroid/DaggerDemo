package demo.tang.tony.test;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.api.TeacherApi;
import demo.tang.tony.di.network.DaggerNetworkComponent;
import demo.tang.tony.model.Teacher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Response;


public class TeacherTest {

    private TeacherApi teacherApi;

    private MockWebServer mockWebServer;

    @Before
    public void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        teacherApi = DaggerNetworkComponent.builder().url(mockWebServer.url("/").toString()).build().teacherApi();
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }


    @Test
    public void addition_isCorrect() throws IOException {

        String json = TestUtils.json("teacher.json", this);
        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody(json);
        mockWebServer.enqueue(mockResponse);
        Truth.assertThat(actual2()).isEqualTo(expected());
    }


    private Teacher actual2() throws IOException {
        Call<Teacher> personCall = teacherApi.get("5c9c4a37360000e655d96f5f");
        Response<Teacher> response = personCall.execute();
        return response.body();
    }


    private Teacher expected() {
        return Teacher.builder().name("TonyTang").id(2).build();
    }
}