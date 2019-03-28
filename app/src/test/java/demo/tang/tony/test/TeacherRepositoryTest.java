package demo.tang.tony.test;

import com.google.common.truth.Truth;

import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.api.TeacherApi;
import demo.tang.tony.di.DaggerNetworkComponent;
import demo.tang.tony.di.NetworkComponent;
import demo.tang.tony.model.Teacher;

public class TeacherRepositoryTest {


    //    http://www.mocky.io/v2/5c9c4a37360000e655d96f5f
    public static final String SERVER_URL = "http://www.mocky.io/v2/";


    @Test
    public void get_by_id_should_return_student() throws IOException {
        TeacherRepository studentRepository = new TeacherRepository(restApi());
        Teacher actual = studentRepository.get("5c9c4a37360000e655d96f5f");
        Truth.assertThat(actual).isEqualTo(Teacher.builder().id(1).name("TonyTang").build());
    }

    private TeacherApi restApi() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .url(SERVER_URL)
                .build();
        return networkComponent.teacherApi();
    }

}