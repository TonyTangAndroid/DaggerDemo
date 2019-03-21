package demo.tang.tony.com.daggerdemo;

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

    @SerializedName("name")
    public abstract NestName name();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(NestName name);

        public abstract Student build();
    }
}
