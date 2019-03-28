package demo.tang.tony.model;

import com.google.auto.value.AutoValue;


@AutoValue
public abstract class Dashboard {

    public static Builder builder() {
        return new AutoValue_Dashboard.Builder();
    }

    public abstract Student student();

    public abstract Teacher teacher();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder student(Student student);

        public abstract Builder teacher(Teacher teacher);

        public abstract Dashboard build();
    }
}
