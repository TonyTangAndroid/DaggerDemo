package demo.tang.tony.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;


@AutoValue
public abstract class Teacher {

    public static TypeAdapter<Teacher> typeAdapter(Gson gson) {
        return new AutoValue_Teacher.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_Teacher.Builder();
    }

    @SerializedName("id")
    public abstract int id();

    @SerializedName("name")
    public abstract String name();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(int id);

        public abstract Builder name(String name);

        public abstract Teacher build();
    }
}
