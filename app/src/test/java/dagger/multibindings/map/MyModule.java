package dagger.multibindings.map;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
class MyModule {
    @Provides
    @IntoMap
    @StringKey("tony")
    static int ageForTony() {
        return 30;
    }

    //Key,Value =>  String -> Long
    //Key,Value =>  String -> Integer

    @Provides
    @IntoMap
    @StringKey("tommy")
    static int ageForTommy() {
        return 100;
    }


    @Provides
    @IntoMap
    @StringKey("tommy1")
    static int ageForTommy1() {
        return 1000;
    }

    @Provides
    static ImmutableMap<String, Integer> immutableMap(Map<String, Integer> daggerMap) {
        return ImmutableMap.copyOf(daggerMap);
    }


    @Provides
    @IntoMap
    @ClassKey(ActivityGoods.class)
    static String provideThingValue() {
        return "value for Thing";
    }

    @Provides
    @IntoMap
    @ClassKey(OrderBean.class)
    static String orderBean() {
        return " value for order bean";
    }

}