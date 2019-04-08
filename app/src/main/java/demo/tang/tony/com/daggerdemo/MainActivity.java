package demo.tang.tony.com.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import demo.tang.tony.model.Dashboard;
import demo.tang.tony.presenter.DashBoardPresenter;
import demo.tang.tony.presenter.DashBoardView;

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

    public void load(View view) {
        DashBoardPresenter dashBoardPresenter = new DashBoardPresenter(this, null);
        dashBoardPresenter.loadNull();

    }
}
