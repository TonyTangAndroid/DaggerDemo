package demo.tang.tony.motif;

@motif.Scope
interface MainScope {

    @motif.Objects
    class Objects {

        Controller controller() {
            return new Controller();
        }
    }

}