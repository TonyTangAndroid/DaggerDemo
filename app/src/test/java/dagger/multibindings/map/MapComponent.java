package dagger.multibindings.map;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import dagger.Component;

@Component(modules = MyModule.class)
interface MapComponent {
    Map<String, Integer> integerByString();

    ImmutableMap<String, Integer> immutableMap();

    Map<Class<?>, String> stringsByClass();
}
