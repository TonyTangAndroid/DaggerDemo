package demo.sub.component;

import dagger.Provides;
import demo.component.shared.Country;
import demo.component.shared.CountryScope;

@dagger.Module
class CountryModule {

    @CountryScope
    @Provides
    public Country country() {
        Country china = Country.builder()
                .countryId(1)
                .countryName("China")
                .build();
        System.out.println("created a country :" + china);
        return china;
    }
}
