package demo.tang.tony.di;

import dagger.BindsInstance;
import dagger.Component;
import demo.tang.tony.api.RestApi;
import demo.tang.tony.api.TeacherApi;

@Component(modules = {RetrofitModule.class})
public interface NetworkComponent {

    RestApi restApi();

    TeacherApi teacherApi();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder url(String url);

        NetworkComponent build();
    }
}