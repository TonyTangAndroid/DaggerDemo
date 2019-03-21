package demo.tang.tony.motif;

class GrandchildController {
    private final View view;
    private final Database database;
    private final ChildView childView;
    private final GrandchildView grandchildView;

    public GrandchildController(View view, Database database, ChildView childView, GrandchildView grandchildView) {
        this.view = view;
        this.childView = childView;
        this.database = database;
        this.grandchildView = grandchildView;
    }

    public View getView() {
        return view;
    }

    public ChildView getChildView() {
        return childView;
    }

    public Database getDatabase() {
        return database;
    }

    public GrandchildView getGrandchildView() {
        return grandchildView;
    }

}
