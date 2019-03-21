package demo.tang.tony.motif;


import motif.Expose;

@motif.Scope
interface MainScope {

    ChildScope child();

    Controller controller();

    @motif.Objects
    abstract class Objects {
        abstract View view();

        @Expose
        abstract Database database();

        abstract Controller controller();
    }

}