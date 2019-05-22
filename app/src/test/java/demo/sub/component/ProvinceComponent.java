package demo.sub.component;


@dagger.Subcomponent(modules = ProvinceModule.class)
@ProvinceScope
public interface ProvinceComponent {

    Province province();

    @dagger.Subcomponent.Builder
    interface Builder {
        ProvinceComponent build();
    }
}