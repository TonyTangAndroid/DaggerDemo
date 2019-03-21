package demo.tang.tony.motif;

class ChildController {
    private final Database database;
    private final ChildView view;


    public ChildController(Database database, ChildView view) {

        this.database = database;
        this.view = view;
    }
}
