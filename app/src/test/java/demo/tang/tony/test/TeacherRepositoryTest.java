package demo.tang.tony.test;

import com.google.common.truth.Truth;

import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.api.TeacherApi;
import demo.tang.tony.di.DaggerNetworkComponent;
import demo.tang.tony.di.NetworkComponent;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.model.Teacher;

public class TeacherRepositoryTest {


    @Test
    public void get_by_id_should_return_student() throws IOException {
        TeacherRepository studentRepository = new TeacherRepository(restApi());
        Teacher actual = studentRepository.get(MockApiConstants.TEACHER_ID);
        Truth.assertThat(actual).isEqualTo(Teacher.builder().id(1).name("TonyTang").build());
    }

    private TeacherApi restApi() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .url(MockApiConstants.SERVER_URL)
                .build();
        return networkComponent.teacherApi();
    }

}