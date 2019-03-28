package demo.tang.tony.test;


import java.io.IOException;

import javax.inject.Inject;

import demo.tang.tony.model.Dashboard;
import demo.tang.tony.model.President;
import demo.tang.tony.model.Student;
import demo.tang.tony.model.Teacher;
import io.reactivex.Single;

public class GetTeacherAndStudentUseCase {


    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private PresidentRepository presidentRepository;

    @Inject
    public GetTeacherAndStudentUseCase(StudentRepository studentRepository,
                                       TeacherRepository teacherRepository,
                                       PresidentRepository presidentRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.presidentRepository = presidentRepository;
    }

    public Single<Dashboard> get(final String teacherId, final String studentId) {

        System.out.println("A Pre get");
        Single<Dashboard> dashboardSingle = Single.fromCallable(() -> getDashboard(teacherId, studentId));
        System.out.println("B Post get");
        return dashboardSingle;

    }

    private Dashboard getDashboard(String teacherId, String studentId) throws IOException {
        Student student = studentRepository.get(studentId);
        Teacher teacher = teacherRepository.get(teacherId);
        President president = presidentRepository.get(teacherId);
        System.out.println("C Dashboard ready");
        return Dashboard.builder().teacher(teacher).president(president).student(student).build();
    }

}