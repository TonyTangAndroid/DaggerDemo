package demo.tang.tony.motif;

class GrandchildController {
    private final ChildView view;
    private final Database database;
    private final GrandchildView grandchildView;

    public GrandchildController(ChildView view, Database database, GrandchildView grandchildView) {
        this.view = view;
        this.database = database;
        this.grandchildView = grandchildView;
    }

    public ChildView getView() {
        return view;
    }

    public Database getDatabase() {
        return database;
    }

    public GrandchildView getGrandchildView() {
        return grandchildView;
    }

}
