package demo.component.dependencies;

import com.google.common.truth.Truth;

import org.junit.Test;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class InjectDemoTest {

    @Inject
    Retrofit retrofit;
    @Inject
    String serverUrl;


    @Test
    public void test1() {
        //手动

        RetrofitTest.RetrofitComponent component = retrofitCompoent();
        retrofit = component.retrofit();
        serverUrl = component.serverUrl();
        Truth.assertThat(retrofit).isNotNull();
        Truth.assertThat(serverUrl).isEqualTo("123");
    }


    @Test
    public void test2() {

        //自动的
        RetrofitTest.RetrofitComponent component = retrofitCompoent();
        component.inject(this);
//        retrofit = component.retrofit();
//        serverUrl = component.serverUrl();
        Truth.assertThat(retrofit).isNotNull();
        Truth.assertThat(serverUrl).isEqualTo("123");
    }


    private RetrofitTest.RetrofitComponent retrofitCompoent() {
        return DaggerRetrofitTest_RetrofitComponent.builder().okhttpComponent(DaggerOKHttpTest_OkhttpComponent.create()).build();
    }


}