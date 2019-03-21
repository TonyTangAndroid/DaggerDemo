package demo.dagger.raw;

import javax.inject.Inject;

@RootComponent.Scope
class RootController {

    private final RootView rootView;

    @Inject
    public RootController(RootView rootView) {
        this.rootView = rootView;
    }
}
