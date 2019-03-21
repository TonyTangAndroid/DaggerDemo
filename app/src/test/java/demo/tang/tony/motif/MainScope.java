package demo.tang.tony.motif;


import motif.Expose;

@motif.Scope
interface MainScope {

    ChildScope child();

    Controller controller();


    @motif.Objects
    abstract class Objects implements ControllerObjects<Controller, View> {
        @Expose
        abstract Database database();
    }

}