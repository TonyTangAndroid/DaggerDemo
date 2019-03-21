package demo.dagger.raw;

import javax.inject.Inject;

class BugController {

    private final RootView rootView;

    @Inject
    public BugController(RootView rootView) {
        this.rootView = rootView;
    }
}
