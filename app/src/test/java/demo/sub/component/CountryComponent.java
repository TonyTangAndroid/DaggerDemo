package demo.sub.component;

@dagger.Component(
        modules = CountryModule.class
)
@CountryScope
public interface CountryComponent {

    Country country();

    ProvinceComponent.Builder provinceComponentBuilder();

}