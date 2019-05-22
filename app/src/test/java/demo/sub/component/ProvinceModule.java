package demo.sub.component;

import dagger.Provides;
import demo.component.shared.Country;
import demo.component.shared.Province;
import demo.component.shared.ProvinceScope;

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
