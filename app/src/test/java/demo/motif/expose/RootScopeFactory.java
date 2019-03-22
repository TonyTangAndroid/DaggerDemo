package demo.motif.expose;

import motif.Scope;

@Scope
public interface RootScopeFactory {

    RootScope create(String value);

    @motif.Dependencies
    interface Dependencies {
    }
}
