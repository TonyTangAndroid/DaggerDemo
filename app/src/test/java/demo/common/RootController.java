package demo.common;

import javax.inject.Inject;

@RootScope
public class RootController {

    private final RootView rootView;

    @Inject
    public RootController(RootView rootView) {
        this.rootView = rootView;
    }
}
