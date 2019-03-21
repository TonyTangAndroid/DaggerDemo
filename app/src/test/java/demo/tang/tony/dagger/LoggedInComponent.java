package demo.tang.tony.dagger;

import dagger.Provides;
import dagger.Subcomponent;

@LoggedInComponent.ChildScope
@Subcomponent(modules = LoggedInComponent.Module.class)
public interface LoggedInComponent {

    ChildView childView();

    @Subcomponent.Builder
    interface Builder {
        LoggedInComponent build();
    }

    @javax.inject.Scope
    @interface ChildScope {
    }


    @dagger.Module
    abstract class Module {

        @ChildScope
        @Provides
        static ChildView childView(RootView rootView) {
            return new ChildView(rootView);
        }
    }
}