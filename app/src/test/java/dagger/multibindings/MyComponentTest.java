package dagger.multibindings;

import com.google.common.collect.ImmutableSet;
import com.google.common.truth.Truth;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyComponentTest {

    @Test
    public void test() {

        MyComponent myComponent = DaggerMyComponent.create();
        Set<String> defaultSet = myComponent.daggerDefaultSet();
        HashSet<String> hashSet = myComponent.hashSet();
        ImmutableSet<String> immutableSet = myComponent.immutableSet();


        Truth.assertThat(defaultSet).isEqualTo(hashSet);
        Truth.assertThat(immutableSet).isEqualTo(hashSet);


        System.out.println("hashSet:" + hashSet);
        System.out.println("defaultSet:" + defaultSet);
        System.out.println("immutableSet:" + immutableSet);

        hashSet.add("xyz");
        System.out.println("hashSet:" + hashSet);

        ImmutableSet<String> newImmutableSet = ImmutableSet.<String>builder()
                .addAll(immutableSet).add("xyz").build();
        System.out.println("newImmutableSet:" + newImmutableSet);


        //True or False
        //TRUE
        //set比较的是 内容，而不是顺序。
        Truth.assertThat(newImmutableSet).isEqualTo(hashSet);

    }

}