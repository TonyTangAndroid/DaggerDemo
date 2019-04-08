package demo.tang.tony.repo;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.api.StudentApi;
import demo.tang.tony.di.DaggerNetworkComponent;
import demo.tang.tony.di.NetworkComponent;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.model.Student;
import demo.tang.tony.repo.StudentRepository;
import demo.tang.tony.test.TestUtils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class StudentRepositoryTest {


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
    public void get_by_id_should_return_student() throws IOException {
        String json = TestUtils.json("student.json", this);
        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody(json);
        mockWebServer.enqueue(mockResponse);




        StudentRepository studentRepository = new StudentRepository(restApi());
        Student actual = studentRepository.get(MockApiConstants.STUDENT_ID);
        Truth.assertThat(actual).isEqualTo(Student.builder().name("tony").build());
    }

    private StudentApi restApi() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .url(mockWebServer.url("/").toString())
                .build();
        return networkComponent.studentApi();
    }

}