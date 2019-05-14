package demo.tang.tony.com.daggerdemo;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
//Singleton
import static demo.tang.tony.model.MockApiConstants.SERVER_URL;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityAndroidInjector;

    @Override
    public void onCreate() {
        inject();
        super.onCreate();
    }

    private void inject() {
        DaggerAppComponent.builder().serverUrl(SERVER_URL).build().inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityAndroidInjector;
    }
}
