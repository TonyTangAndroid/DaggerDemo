package demo.dagger.raw;

import dagger.Provides;
import dagger.Subcomponent;
import demo.common.ChildView;
import demo.common.RootView;

@LoggedInComponent.ChildScope
@Subcomponent(modules = LoggedInComponent.Module.class)
interface LoggedInComponent {

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