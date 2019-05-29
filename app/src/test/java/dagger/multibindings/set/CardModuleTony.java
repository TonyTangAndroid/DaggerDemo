package dagger.multibindings.set;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
class CardModuleTony {

    @Provides
    @IntoSet
    static String provideOneString() {
        return "ABC";
    }

    @Provides
    @IntoSet
    static String provideSecondString() {
        return "DEF";
    }

    @Provides
    static HashSet<String> mutableHashSet(Set<String> daggerComposedSetWhichIsMutable) {
        return new HashSet<>(daggerComposedSetWhichIsMutable);
    }

    @Provides
    static ImmutableSet<String> immutableSet(Set<String> daggerComposedSetWhichIsMutable) {
        return ImmutableSet.<String>builder().addAll(daggerComposedSetWhichIsMutable).build();
    }

}