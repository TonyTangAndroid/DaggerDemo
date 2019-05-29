package dagger.multibindings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;

@Module
class CardModuleSloth {
    @Provides
    @ElementsIntoSet
    static Set<String> provideSomeStrings() {
        return new HashSet<String>(Arrays.asList("JKL", "GHI"));
    }
}