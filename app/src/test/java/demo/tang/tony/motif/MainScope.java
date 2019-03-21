package demo.tang.tony.motif;


import motif.Expose;

@motif.Scope
interface MainScope {

    ChildScope child();

    Controller controller();

    @motif.Objects
    class Objects {

        View view() {
            return new View();
        }

        @Expose
        Database database() {
            return new Database();
        }

        Controller controller(View view, Database database) {
            return new Controller(view, database);
        }
    }

}