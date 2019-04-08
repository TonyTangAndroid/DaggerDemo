package demo.tang.tony.presenter;

import demo.tang.tony.model.Dashboard;
import demo.tang.tony.usecase.GetTeacherAndStudentUseCase;
import io.reactivex.observers.DisposableSingleObserver;

public class DashBoardPresenter {

    private final DashBoardView dashBoardView;
    private final GetTeacherAndStudentUseCase useCase;

    public DashBoardPresenter(DashBoardView dashBoardView, GetTeacherAndStudentUseCase useCase) {

        this.dashBoardView = dashBoardView;
        this.useCase = useCase;
    }

    public void load(String studentId, String teacherId) {
        useCase.setParams(studentId, teacherId).execute(new DisposableSingleObserver<Dashboard>() {
            @Override
            public void onSuccess(Dashboard dashboard) {
                dashBoardView.showDashBoard(dashboard);
            }

            @Override
            public void onError(Throwable e) {
                dashBoardView.showError(e);
            }
        });
    }

}
