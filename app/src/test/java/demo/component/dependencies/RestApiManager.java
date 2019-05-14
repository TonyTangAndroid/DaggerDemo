package demo.component.dependencies;

import retrofit2.Retrofit;

public class RestApiManager {


    //什么时候使用@Inject 这个方法。Activity, Fragment
    //构造方法不是你自己控制的时候，那么你就得去 使用@Inject。


    private final Retrofit retrofit;
    private final String serverUrl;

    RestApiManager(Retrofit retrofit, String serverUrl) {
        this.retrofit = retrofit;
        this.serverUrl = serverUrl;
    }

    public RestApi createRestApi(Class<? extends RestApi> className) {
        return retrofit.create(className);
    }


}