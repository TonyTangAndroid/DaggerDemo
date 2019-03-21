package di.motif.example;

import motif.Expose;

interface ControllerObjects<C, V> {

    @Expose
    V view();

    C controller();
}