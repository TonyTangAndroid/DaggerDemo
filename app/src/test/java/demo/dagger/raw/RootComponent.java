package demo.dagger.raw;


import javax.inject.Qualifier;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;

@RootComponent.Scope
@Component(modules = RootComponent.Module.class)
public interface RootComponent {

    RootController rootController();

    BugController bugController();

    LoggedInComponent.Builder loggedIn();

    @dagger.Component.Builder
    interface Builder {

        @BindsInstance
        Builder viewGroup(@Root ViewGroup parent);

        RootComponent build();
    }

    @javax.inject.Scope
    @interface Scope {
    }

    @Qualifier
    @interface Root {
    }

    @dagger.Module
    abstract class Module {

        @Scope
        @Provides
        static RootView view(@Root ViewGroup parent) {
            return RootView.create(parent);
        }
    }
}