package demo.tang.tony.presenter;

import demo.tang.tony.model.Dashboard;

public interface DashBoardView {
    void showDashBoard(Dashboard dashboard);

    void showError(Throwable throwable);
}
