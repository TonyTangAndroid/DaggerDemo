package demo.tang.tony.usecase;

import dagger.Component;
import demo.tang.tony.di.NetworkComponent;

@Component(dependencies = NetworkComponent.class)
public interface UseCaseComponent {

    GetTeacherAndStudentUseCase useCase();

    @Component.Builder
    interface Builder {

        Builder networkComponent(NetworkComponent url);

        UseCaseComponent build();
    }
}