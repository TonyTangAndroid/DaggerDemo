package demo.component.shared;

import com.google.auto.value.AutoValue;


@AutoValue
public abstract class Province {


    public static Builder builder() {
        return new AutoValue_Province.Builder();
    }

    public abstract Country country();

    public abstract String provinceId();

    public abstract String provinceName();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder country(Country country);

        public abstract Builder provinceId(String provinceId);

        public abstract Builder provinceName(String provinceName);

        public abstract Province build();
    }
}
