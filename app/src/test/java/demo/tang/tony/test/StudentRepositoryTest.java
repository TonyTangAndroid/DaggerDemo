package demo.tang.tony.test;

import com.google.common.truth.Truth;

import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.api.StudentApi;
import demo.tang.tony.di.DaggerNetworkComponent;
import demo.tang.tony.di.NetworkComponent;
import demo.tang.tony.model.Student;

public class StudentRepositoryTest {

    public static final String SERVER_URL = "http://www.mocky.io/v2/";


    @Test
    public void get_by_id_should_return_student() throws IOException {
        StudentRepository studentRepository = new StudentRepository(restApi());
        Student actual = studentRepository.get("5c9302e0320000e51c6bd167");
        Truth.assertThat(actual).isEqualTo(Student.builder().name("tony").build());
    }

    private StudentApi restApi() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .url(SERVER_URL)
                .build();
        return networkComponent.restApi();
    }

}