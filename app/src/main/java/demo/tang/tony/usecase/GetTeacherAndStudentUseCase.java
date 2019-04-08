package demo.tang.tony.usecase;


import java.io.IOException;

import javax.inject.Inject;

import demo.tang.tony.model.Dashboard;
import demo.tang.tony.model.President;
import demo.tang.tony.model.Student;
import demo.tang.tony.model.Teacher;
import demo.tang.tony.repo.PresidentRepository;
import demo.tang.tony.repo.StudentRepository;
import demo.tang.tony.repo.TeacherRepository;
import io.reactivex.Single;

public class GetTeacherAndStudentUseCase extends SingleUseCase<Dashboard> {


    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private PresidentRepository presidentRepository;
    private String teacherId;
    private String studentId;

    @Inject
    public GetTeacherAndStudentUseCase(ThreadExecutor threadExecutor,
                                       UIThread uiThread,
                                       StudentRepository studentRepository,
                                       TeacherRepository teacherRepository,
                                       PresidentRepository presidentRepository) {
        super(threadExecutor, uiThread);
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.presidentRepository = presidentRepository;
    }

    public GetTeacherAndStudentUseCase setParams(final String teacherId, final String studentId) {
        this.teacherId = teacherId;
        this.studentId = studentId;
        return this;

    }

    private Dashboard getDashboard(String teacherId, String studentId) throws IOException {
        Student student = studentRepository.get(studentId);
        Teacher teacher = teacherRepository.get(teacherId);
        President president = presidentRepository.get(teacherId);
        return Dashboard.builder().teacher(teacher).president(president).student(student).build();
    }

    @Override
    public Single<Dashboard> build() {
        return Single.fromCallable(() -> getDashboard(teacherId, studentId));
    }
}