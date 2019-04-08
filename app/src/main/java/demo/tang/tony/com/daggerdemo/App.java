package demo.tang.tony.com.daggerdemo;

import android.app.Application;

import demo.tang.tony.model.MockApiConstants;

public class App extends Application {

    private AppComponent appComponent;

    public AppComponent appComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().serverUrl(MockApiConstants.SERVER_URL).build();
    }
}
