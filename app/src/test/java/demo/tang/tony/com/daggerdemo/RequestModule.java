package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import okhttp3.Request;

@Module
class RequestModule {

    @Provides
    public Request request(String url) {
        return new Request.Builder()
                .url(url)
                .build();
    }
}
