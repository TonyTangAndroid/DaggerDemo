package demo.tang.tony.dagger;


class RootView {
    private final ViewGroup parent;

    public RootView(ViewGroup parent) {

        this.parent = parent;
    }

    public static RootView create(ViewGroup parent) {
        return new RootView(parent);
    }
}
