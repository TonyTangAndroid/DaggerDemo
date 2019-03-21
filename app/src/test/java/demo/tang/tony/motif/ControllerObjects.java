package demo.tang.tony.motif;

import motif.Expose;

interface ControllerObjects<C, V> {

    @Expose
    V view();

    C controller();
}