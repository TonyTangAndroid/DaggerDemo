package demo.tang.tony.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;


@AutoValue
public abstract class Student {

    public static TypeAdapter<Student> typeAdapter(Gson gson) {
        return new AutoValue_Student.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_Student.Builder();
    }

    @Nullable
    @SerializedName("name")
    public abstract String name();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Student build();
    }
}
