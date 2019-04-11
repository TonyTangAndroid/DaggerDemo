package demo.component.dependencies;

import com.google.common.truth.Truth;

import org.junit.Test;

import okhttp3.OkHttpClient;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OKHttpTest {
    @Test
    public void test() {
//        OkHttpClient mockOkHttpClient = mock(OkHttpClient.class);
//        HttpModule mockHttpModule = mock(HttpModule.class);
//        given(mockHttpModule.okHttpClient1()).willReturn(mockOkHttpClient);
//        OkhttpComponent component = DaggerOKHttpTest_OkhttpComponent.builder().httpModule(mockHttpModule).build();//2
//        OkHttpClient actual = component.okHttpClient();
//        Truth.assertThat(actual).isEqualTo(mockOkHttpClient);
    }


    @dagger.Component(modules = HttpModule.class)
    public interface OkhttpComponent {

        //output
        OkHttpClient okHttpClient();
    }

    @dagger.Module
    static class HttpModule {

        @dagger.Provides
        OkHttpClient okHttpClient1() {
            return new OkHttpClient();
        }

    }


    // without an @Inject constructor
}