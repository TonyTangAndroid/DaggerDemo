package demo.sub.component;

import dagger.Provides;

@dagger.Module
class ProvinceModule {

    @ProvinceScope
    @Provides
    public Province province(Country country) {

        return Province.builder()
                .country(country)
                .provinceId("010")
                .provinceName("Beijing")
                .build();
    }

}
