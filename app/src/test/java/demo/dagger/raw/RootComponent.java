package demo.dagger.raw;


import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;
import demo.common.RootController;
import demo.common.RootQualifier;
import demo.common.RootScope;
import demo.common.RootView;
import demo.common.ViewGroup;

@RootScope
@Component(modules = RootComponent.Module.class)
interface RootComponent {

    RootController rootController();

    BugController bugController();

    LoggedInComponent.Builder loggedIn();

    @dagger.Component.Builder
    interface Builder {

        @BindsInstance
        Builder viewGroup(@RootQualifier ViewGroup parent);

        RootComponent build();
    }

    @dagger.Module
    abstract class Module {

        @RootScope
        @Provides
        static RootView view(@RootQualifier ViewGroup parent) {
            return RootView.create(parent);
        }
    }
}