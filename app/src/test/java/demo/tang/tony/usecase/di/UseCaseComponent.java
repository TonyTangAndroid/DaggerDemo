package demo.tang.tony.usecase.di;

import dagger.Component;
import demo.tang.tony.di.network.NetworkComponent;
import demo.tang.tony.usecase.GetTeacherAndStudentUseCase;
import demo.tang.tony.usecase.ThreadModule;

@Component(modules = ThreadModule.class,dependencies = NetworkComponent.class)
public interface UseCaseComponent {

    GetTeacherAndStudentUseCase useCase();

    @Component.Builder
    interface Builder {

        Builder networkComponent(NetworkComponent url);

        UseCaseComponent build();
    }
}