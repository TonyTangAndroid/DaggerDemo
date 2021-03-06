package demo.tang.tony.usecase;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import demo.tang.tony.model.Dashboard;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.model.President;
import demo.tang.tony.model.Student;
import demo.tang.tony.model.Teacher;
import demo.tang.tony.repo.PresidentRepository;
import demo.tang.tony.repo.StudentRepository;
import demo.tang.tony.repo.TeacherRepository;
import io.reactivex.Single;

import static org.mockito.BDDMockito.given;

public class GetTeacherAndStudentUseCaseNoDaggerTest {


    @Mock
    private StudentRepository studentRepository;
    @Mock
    private TeacherRepository teacherRepository;
    @Mock
    private PresidentRepository presidentRepository;
    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private UIThread uiThread;


    @Test
    public void get() throws IOException {

        MockitoAnnotations.initMocks(this);

        GetTeacherAndStudentUseCase useCase = new GetTeacherAndStudentUseCase(
                threadExecutor,
                uiThread,
                studentRepository,
                teacherRepository,
                presidentRepository);


        given(studentRepository.get(MockApiConstants.STUDENT_ID)).willReturn(Student.builder().name("tony").build());
        given(teacherRepository.get(MockApiConstants.TEACHER_ID)).willReturn(Teacher.builder().id(1).name("TonyTang").build());
        given(presidentRepository.get(MockApiConstants.TEACHER_ID)).willReturn(President.builder().name("TonyTang").build());


        Single<Dashboard> single = useCase.setParams(MockApiConstants.TEACHER_ID, MockApiConstants.STUDENT_ID).build();
        single.test().assertValue(expected());

    }


    private Dashboard expected() {
        President president = President.builder().name("TonyTang").build();
        Teacher teacher = Teacher.builder().id(1).name("TonyTang").build();
        Student student = Student.builder().name("tony").build();
        return Dashboard.builder().student(student).president(president).teacher(teacher).build();
    }
}