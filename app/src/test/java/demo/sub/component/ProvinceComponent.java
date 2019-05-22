package demo.sub.component;

@dagger.Component(modules = ProvinceModule.class)
@ProvinceScope
public interface ProvinceComponent {

    Province province();
}