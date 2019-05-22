package demo.component.shared;

import dagger.Provides;

@dagger.Module
public class ProvinceModule {

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
