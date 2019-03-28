package demo.tang.tony.di;

import dagger.BindsInstance;
import dagger.Component;
import demo.tang.tony.api.StudentApi;
import demo.tang.tony.api.TeacherApi;

@Component(modules = {RetrofitModule.class,
        HiddenOkHttpClientModule.class})
public interface NetworkComponent {

    StudentApi restApi();

    TeacherApi teacherApi();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder url(String url);

        NetworkComponent build();
    }
}