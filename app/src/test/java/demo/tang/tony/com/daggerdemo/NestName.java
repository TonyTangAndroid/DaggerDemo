package demo.tang.tony.com.daggerdemo;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class NestName {

    public static TypeAdapter<NestName> typeAdapter(Gson gson) {
        return new AutoValue_NestName.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_NestName.Builder();
    }

    @Nullable
    @SerializedName("name1")
    public abstract String name();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract NestName build();
    }
}
