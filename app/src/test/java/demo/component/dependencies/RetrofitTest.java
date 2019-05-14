package demo.component.dependencies;

import org.junit.Test;

import dagger.Provides;
import demo.tang.tony.model.MockApiConstants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitTest {


    @Test
    public void test1() {

        //发送网络请求
        OkHttpClient okHttpClient = new OkHttpClient();


        OKHttpTest.OkhttpComponent okhttpComponent = DaggerOKHttpTest_OkhttpComponent.create();

        RetrofitComponent component = DaggerRetrofitTest_RetrofitComponent.builder().okhttpComponent(okhttpComponent).build();


//        Truth.assertThat(component.retrofit()).isNotNull();


    }


    @dagger.Component(modules = RetrofitTestModule.class, dependencies = OKHttpTest.OkhttpComponent.class)
    public interface RetrofitComponent {


        //helper函数
        void inject(InjectDemoTest injectDemoTest);

        void inject(RestApiManager injectDemoTest);

//        //output
//        Retrofit retrofit();
//
//        String serverUrl();

    }

    @dagger.Module
    static class RetrofitTestModule {

        @Provides
        Retrofit provideRetrofit(OkHttpClient okHttpClient) {
            return new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(MockApiConstants.SERVER_URL)
                    .build();
        }

        @Provides
        String serverUrl() {
            return "123";
        }
    }


//    @dagger.Component(modules = HttpModule.class)
//    public interface NetworkComponent {
//        //output
//        OkHttpClient okHttpClient();
//    }
//
//    @dagger.Module
//    static class HttpModule {
//
//        @dagger.Provides
//        OkHttpClient okHttpClient1() {
//            return new OkHttpClient();
//        }
//
//    }


    // without an @Inject constructor
}