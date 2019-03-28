package demo.tang.tony.test;

import org.junit.Test;

import java.io.IOException;

import demo.tang.tony.di.DaggerNetworkComponent;
import demo.tang.tony.di.NetworkComponent;
import demo.tang.tony.model.Dashboard;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.model.Student;
import demo.tang.tony.model.Teacher;
import io.reactivex.Single;

public class GetTeacherAndStudentUseCaseTest {

    @Test
    public void get() {

        GetTeacherAndStudentUseCase useCase = useCase();
        Single<Dashboard> single = useCase.get(MockApiConstants.TEACHER_ID, MockApiConstants.STUDENT_ID);
        single.test().assertValue(expected());

    }

    private GetTeacherAndStudentUseCase useCase() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder().url(MockApiConstants.SERVER_URL).build();
        return DaggerUseCaseComponent.builder().networkComponent(networkComponent).build().useCase();
    }

    private Dashboard expected() {
        Teacher teacher = Teacher.builder().id(1).name("TonyTang").build();
        Student student = Student.builder().name("tony").build();
        return Dashboard.builder().student(student).teacher(teacher).build();
    }
}