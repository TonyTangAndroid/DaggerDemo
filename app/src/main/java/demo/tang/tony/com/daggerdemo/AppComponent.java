package demo.tang.tony.com.daggerdemo;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import demo.tang.tony.di.HiddenOkHttpClientModule;
import demo.tang.tony.di.RetrofitModule;
import demo.tang.tony.usecase.ThreadModule;

@Component(modules = {
        AndroidInjectionModule.class,
        ActivityBuilder.class,
        ThreadModule.class,
        RetrofitModule.class,
        HiddenOkHttpClientModule.class
})
@AppScope
public interface AppComponent {

    void inject(App app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder serverUrl(String serverUrl);

        AppComponent build();
    }
}