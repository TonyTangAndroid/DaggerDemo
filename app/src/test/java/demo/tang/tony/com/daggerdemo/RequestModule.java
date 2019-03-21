package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import okhttp3.Request;

@Module
class RequestModule {

    @Provides
    public Request request() {
        return new Request.Builder()
                .url("http://www.mocky.io/v2/5c9302e0320000e51c6bd167")
                .build();
    }

}
