package demo.tang.tony.com.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
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
        inject();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_dashboard = findViewById(R.id.tv_dashboard);
    }

    private void inject() {
        DaggerMainActivity_MainActivityComponent.builder()
                .appComponent(((App) getApplication()).appComponent())
                .module(new MainActivityModule(this))
                .build().inject(this);

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

    @Component(modules = {MainActivityModule.class}
            , dependencies = AppComponent.class)
    public interface MainActivityComponent {

        void inject(MainActivity mainActivity);

        @Component.Builder
        interface Builder {

            Builder module(MainActivityModule mainActivityModule);

            Builder appComponent(AppComponent appComponent);

            MainActivityComponent build();
        }
    }

    @Module
    static
    class MainActivityModule {

        private final MainActivity mainActivity;

        public MainActivityModule(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        @Provides
        DashBoardView dashBoardView() {
            return mainActivity;
        }
    }
}
