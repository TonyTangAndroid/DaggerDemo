package demo.component.shared;

import com.google.auto.value.AutoValue;


@AutoValue
public abstract class Country {

    public static Builder builder() {
        return new AutoValue_Country.Builder();
    }

    public abstract int countryId();

    public abstract String countryName();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder countryId(int countryId);

        public abstract Builder countryName(String countryName);

        public abstract Country build();
    }
}
