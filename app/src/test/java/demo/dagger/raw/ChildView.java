package demo.dagger.raw;

class ChildView {
    private final RootView rootView;

    public ChildView(RootView rootView) {
        this.rootView = rootView;

    }

    public RootView getRootView() {
        return rootView;
    }

}
