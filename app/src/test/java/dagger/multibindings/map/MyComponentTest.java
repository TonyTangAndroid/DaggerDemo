package dagger.multibindings.map;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

public class MyComponentTest {

    @Test
    public void testMyComponent() {
        MapComponent myComponent = DaggerMapComponent.create();
        Map<String, Integer> map = myComponent.integerByString();

        Integer tommy = map.get("tommy");
        assertThat(tommy).isEqualTo(100);
        System.out.println(map);
        ImmutableMap<String, Integer> immutableMap = myComponent.immutableMap();
        System.out.println(immutableMap);


        Map<Class<?>, String> classStringMap = myComponent.stringsByClass();
        assertThat(classStringMap.get(ActivityGoods.class))
                .isEqualTo("value for Thing");

        System.out.println(classStringMap);
    }


}