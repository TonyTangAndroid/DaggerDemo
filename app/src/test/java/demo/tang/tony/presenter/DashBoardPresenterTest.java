package demo.tang.tony.presenter;

import org.junit.Test;

import demo.tang.tony.model.Dashboard;
import demo.tang.tony.usecase.GetTeacherAndStudentUseCase;
import io.reactivex.Single;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DashBoardPresenterTest {
    @Test
    public void test() {

        Dashboard dashboard = mock(Dashboard.class);
        GetTeacherAndStudentUseCase useCase = mock(GetTeacherAndStudentUseCase.class);
        given(useCase.get("1", "1")).willReturn(Single.just(dashboard));
        DashBoardView dashBoardView = mock(DashBoardView.class);
        DashBoardPresenter dashBoardPresenter = new DashBoardPresenter(dashBoardView, useCase);
        dashBoardPresenter.load("1", "1");
        verify(dashBoardView).showDashBoard(dashboard);
    }

}