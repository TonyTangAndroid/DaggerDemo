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
    public void get() throws IOException {

        NetworkComponent networkComponent = DaggerNetworkComponent.builder().url(MockApiConstants.SERVER_URL).build();
        StudentRepository studentRepository = new StudentRepository(networkComponent.studentApi());
        TeacherRepository teacherRepository = new TeacherRepository(networkComponent.teacherApi());
        GetTeacherAndStudentUseCase useCase = new GetTeacherAndStudentUseCase(studentRepository, teacherRepository);
        Single<Dashboard> single = useCase.get(MockApiConstants.TEACHER_ID, MockApiConstants.STUDENT_ID);
        single.test().assertValue(expected());

    }

    private Dashboard expected() {
        Teacher teacher = Teacher.builder().id(1).name("TonyTang").build();
        Student student = Student.builder().name("tony").build();
        return Dashboard.builder().student(student).teacher(teacher).build();
    }
}