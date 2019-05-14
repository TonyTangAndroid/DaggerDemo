package demo.tang.tony.repo;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.api.TeacherApi;
import demo.tang.tony.di.DaggerNetworkComponent;
import demo.tang.tony.di.NetworkComponent;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.model.Teacher;
import demo.tang.tony.test.TestUtils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class TeacherRepositoryTest {

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
    public void get_by_id_should_return_student() throws IOException {
        String json = TestUtils.json("teacher.json", this);
        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody(json);
        mockWebServer.enqueue(mockResponse);



        TeacherRepository studentRepository = new TeacherRepository(restApi());
        Teacher actual = studentRepository.get(MockApiConstants.TEACHER_ID);
        Truth.assertThat(actual).isEqualTo(Teacher.builder().id(2).name("TonyTang").build());
    }

    private TeacherApi restApi() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .url(mockWebServer.url("/").toString())
                .build();
        return networkComponent.teacherApi();
    }

}