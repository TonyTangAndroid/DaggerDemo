package dagger.multibindings;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

import dagger.Component;

@Component(modules = {CardModuleTony.class, CardModuleSloth.class})
interface MyComponent {

    Set<String> daggerDefaultSet();

    HashSet<String> hashSet();

    ImmutableSet<String> immutableSet();
}