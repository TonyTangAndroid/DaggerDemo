package di.motif.example;

class Controller {
    private final View view;
    private final Database database;

    public Controller(View view, Database database) {

        this.view = view;
        this.database = database;
    }
}
