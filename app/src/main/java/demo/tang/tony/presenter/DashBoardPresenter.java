package demo.tang.tony.presenter;

import demo.tang.tony.model.Dashboard;
import demo.tang.tony.usecase.GetTeacherAndStudentUseCase;

public class DashBoardPresenter {

    private final DashBoardView dashBoardView;
    private final GetTeacherAndStudentUseCase useCase;

    public DashBoardPresenter(DashBoardView dashBoardView, GetTeacherAndStudentUseCase useCase) {

        this.dashBoardView = dashBoardView;
        this.useCase = useCase;
    }

    public void load(String studentId, String teacherId) {
        Dashboard dashboard = useCase.get(studentId, teacherId).blockingGet();
        dashBoardView.showDashBoard(dashboard);
    }

    public void loadNull() {
        dashBoardView.showDashBoard(null);
    }
}
