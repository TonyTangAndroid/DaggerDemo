package demo.sub.component;

import demo.component.shared.Country;
import demo.component.shared.CountryScope;

@dagger.Component(
        modules = CountryModule.class
)
@CountryScope
public interface CountryComponent {

    Country country();

    ProvinceComponent.Builder provinceComponentBuilder();

}