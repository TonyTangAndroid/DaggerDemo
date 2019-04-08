package demo.tang.tony.com.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjection;
import demo.tang.tony.model.Dashboard;
import demo.tang.tony.model.MockApiConstants;
import demo.tang.tony.presenter.DashBoardPresenter;
import demo.tang.tony.presenter.DashBoardView;

public class MainActivity extends AppCompatActivity implements DashBoardView {

    @Inject
    DashBoardPresenter dashBoardPresenter;

    private TextView tv_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
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
        dashBoardPresenter.load(MockApiConstants.STUDENT_ID, MockApiConstants.TEACHER_ID);
    }

    @Module
    public abstract class MainActivityModule {

        @Binds
        abstract DashBoardView dashBoardView(MainActivity mainActivity);
    }
}
