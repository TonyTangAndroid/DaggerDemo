package demo.dagger.raw;


import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;
import demo.common.Root;
import demo.common.RootController;
import demo.common.RootView;
import demo.common.Scope;
import demo.common.ViewGroup;

@Scope
@Component(modules = RootComponent.Module.class)
interface RootComponent {

    RootController rootController();

    BugController bugController();

    LoggedInComponent.Builder loggedIn();

    @dagger.Component.Builder
    interface Builder {

        @BindsInstance
        Builder viewGroup(@Root ViewGroup parent);

        RootComponent build();
    }

    @dagger.Module
    abstract class Module {

        @Scope
        @Provides
        static RootView view(@Root ViewGroup parent) {
            return RootView.create(parent);
        }

        @Scope
        @Provides
        static RootController rootController(RootView rootView) {
            return new RootController(rootView);
        }
    }
}