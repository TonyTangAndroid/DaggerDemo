package demo.dagger.raw;

import javax.inject.Inject;

import demo.common.RootView;

class BugController {

    private final RootView rootView;

    @Inject
    public BugController(RootView rootView) {
        this.rootView = rootView;
    }
}
