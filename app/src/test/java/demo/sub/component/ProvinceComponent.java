package demo.sub.component;


import demo.component.shared.Province;
import demo.component.shared.ProvinceModule;
import demo.component.shared.ProvinceScope;

@dagger.Subcomponent(modules = ProvinceModule.class)
@ProvinceScope
public interface ProvinceComponent {

    Province province();

    @dagger.Subcomponent.Builder
    interface Builder {
        ProvinceComponent build();
    }
}