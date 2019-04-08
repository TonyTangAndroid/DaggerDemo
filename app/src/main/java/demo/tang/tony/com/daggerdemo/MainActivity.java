package demo.tang.tony.com.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import demo.tang.tony.di.DaggerNetworkComponent;
import demo.tang.tony.di.NetworkComponent;
import demo.tang.tony.model.Dashboard;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.presenter.DashBoardPresenter;
import demo.tang.tony.presenter.DashBoardView;
import demo.tang.tony.usecase.DaggerUseCaseComponent;
import demo.tang.tony.usecase.GetTeacherAndStudentUseCase;

public class MainActivity extends AppCompatActivity implements DashBoardView {

    private TextView tv_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_dashboard = findViewById(R.id.tv_dashboard);
    }


    @Override
    public void showDashBoard(Dashboard dashboard) {
        tv_dashboard.setText(dashboard == null ? "no data yet" : dashboard.toString());
    }

    @Override
    public void showError(Throwable throwable) {
        throwable.printStackTrace();
        tv_dashboard.setText(throwable.getMessage());
    }

    public void load(View view) {
        DashBoardPresenter dashBoardPresenter = new DashBoardPresenter(this, useCase());
        dashBoardPresenter.load(MockApiConstants.STUDENT_ID, MockApiConstants.TEACHER_ID);

    }

    private GetTeacherAndStudentUseCase useCase() {
        NetworkComponent networkComponent = DaggerNetworkComponent.builder().url(MockApiConstants.SERVER_URL).build();
        return DaggerUseCaseComponent.builder().networkComponent(networkComponent).build().useCase();
    }

}
