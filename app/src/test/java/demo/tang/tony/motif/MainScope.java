package demo.tang.tony.motif;


@motif.Scope
interface MainScope {

    Controller controller();


    @motif.Objects
    class Objects {

        View view() {
            return new View();
        }

        Database database() {
            return new Database();
        }

        Controller controller(View view, Database database) {
            return new Controller(view, database);
        }
    }

}