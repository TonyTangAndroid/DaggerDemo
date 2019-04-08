package demo.tang.tony.com.daggerdemo;

import dagger.BindsInstance;
import dagger.Component;
import demo.tang.tony.di.HiddenOkHttpClientModule;
import demo.tang.tony.di.RetrofitModule;
import demo.tang.tony.usecase.GetTeacherAndStudentUseCase;
import demo.tang.tony.usecase.ThreadModule;

@Component(modules = {ThreadModule.class,
        RetrofitModule.class,
        HiddenOkHttpClientModule.class
})
public interface AppComponent {

    void inject(App app);

    GetTeacherAndStudentUseCase getTeacherAndStudentUseCase();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder serverUrl(String serverUrl);

        AppComponent build();
    }
}