package demo.dependencies.component;


import demo.component.shared.Province;
import demo.component.shared.ProvinceModule;
import demo.component.shared.ProvinceScope;

@dagger.Component(modules = ProvinceModule.class,
        dependencies = CountryComponent.class)
@ProvinceScope
public interface ProvinceComponent {

    Province province();

    @dagger.Component.Builder
    interface Builder {

        Builder countryComponent(CountryComponent countryComponent);

        ProvinceComponent build();
    }
}