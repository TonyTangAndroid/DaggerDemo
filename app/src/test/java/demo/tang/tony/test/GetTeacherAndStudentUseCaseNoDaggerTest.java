package demo.tang.tony.test;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import demo.tang.tony.model.Dashboard;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.model.President;
import demo.tang.tony.model.Student;
import demo.tang.tony.model.Teacher;
import io.reactivex.Single;

import static org.mockito.BDDMockito.given;

public class GetTeacherAndStudentUseCaseNoDaggerTest {


    @Mock
    private StudentRepository studentRepository;
    @Mock
    private TeacherRepository teacherRepository;
    @Mock
    private PresidentRepository presidentRepository;


    @Test
    public void get() throws IOException {

        MockitoAnnotations.initMocks(this);

        GetTeacherAndStudentUseCase useCase = new GetTeacherAndStudentUseCase(
                studentRepository,
                teacherRepository,
                presidentRepository);


        given(studentRepository.get(MockApiConstants.STUDENT_ID)).willReturn(Student.builder().name("tony").build());
        given(teacherRepository.get(MockApiConstants.TEACHER_ID)).willReturn(Teacher.builder().id(1).name("TonyTang").build());
        given(presidentRepository.get(MockApiConstants.TEACHER_ID)).willReturn(President.builder().name("TonyTang").build());


        Single<Dashboard> single = useCase.get(MockApiConstants.TEACHER_ID, MockApiConstants.STUDENT_ID);
        single.test().assertValue(expected());

    }


    private Dashboard expected() {
        President president = President.builder().name("TonyTang").build();
        Teacher teacher = Teacher.builder().id(1).name("TonyTang").build();
        Student student = Student.builder().name("tony").build();
        return Dashboard.builder().student(student).president(president).teacher(teacher).build();
    }
}