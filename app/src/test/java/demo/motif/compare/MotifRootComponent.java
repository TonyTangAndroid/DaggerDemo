package demo.motif.compare;


import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;
import demo.common.RootController;
import demo.common.Scope;
import demo.common.RootView;
import demo.common.ViewGroup;

@Scope
@Component(modules = MotifRootComponent.Module.class)
interface MotifRootComponent {

    RootController rootController();

    BugController bugController();

    LoggedInComponent.Builder loggedIn();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder viewGroup(ViewGroup parent);

        MotifRootComponent build();
    }


    @dagger.Module
    abstract class Module {

        @Scope
        @Provides
        static RootView view(ViewGroup parent) {
            return RootView.create(parent);
        }
    }
}