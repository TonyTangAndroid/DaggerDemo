package demo.sub.component;

import dagger.Provides;

@dagger.Module
class ProvinceModule {

    @ProvinceScope
    @Provides
    public Province province() {
        throw new RuntimeException("todo");
    }

}
