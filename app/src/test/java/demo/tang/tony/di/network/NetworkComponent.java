package demo.tang.tony.di.network;

import dagger.BindsInstance;
import dagger.Component;
import demo.tang.tony.api.PresidentApi;
import demo.tang.tony.api.StudentApi;
import demo.tang.tony.api.TeacherApi;

@Component(modules = {RetrofitTestModule.class,
        HiddenOkHttpClientTestModule.class})
public interface NetworkComponent {

    StudentApi studentApi();

    TeacherApi teacherApi();

    PresidentApi presidentApi();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder url(String url);

        NetworkComponent build();
    }
}