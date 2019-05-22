package demo.tang.tony.usecase.di;

import dagger.Component;
import demo.tang.tony.di.network.NetworkComponent;
import demo.tang.tony.usecase.GetTeacherAndStudentUseCase;

@Component(modules = ThreadTestModule.class, dependencies = NetworkComponent.class)
public interface UseCaseComponent {

    GetTeacherAndStudentUseCase useCase();

    @Component.Builder
    interface Builder {

        Builder networkComponent(NetworkComponent url);

        UseCaseComponent build();
    }
}