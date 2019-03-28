package demo.tang.tony.test;


import java.io.IOException;

import demo.tang.tony.di.DaggerNetworkComponent;
import demo.tang.tony.di.NetworkComponent;
import demo.tang.tony.model.Dashboard;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.model.Student;
import demo.tang.tony.model.Teacher;
import io.reactivex.Single;

public class GetTeacherAndStudentUseCase {


    public Single<Dashboard> get(String teacherId, String studentId) throws IOException {

        NetworkComponent networkComponent = DaggerNetworkComponent.builder().url(MockApiConstants.SERVER_URL).build();

        StudentRepository studentRepository = new StudentRepository(networkComponent.studentApi());
        TeacherRepository teacherRepository = new TeacherRepository(networkComponent.teacherApi());
        Student student = studentRepository.get(studentId);
        Teacher teacher = teacherRepository.get(teacherId);
        Dashboard dashboard = Dashboard.builder().teacher(teacher).student(student).build();
        return Single.just(dashboard);

    }

}