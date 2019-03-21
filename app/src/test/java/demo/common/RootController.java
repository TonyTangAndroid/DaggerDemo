package demo.common;

public class RootController {

    private final RootView rootView;

    public RootController(RootView rootView) {
        this.rootView = rootView;
    }

    public RootView getRootView() {
        return rootView;
    }
}
