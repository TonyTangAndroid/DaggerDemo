package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivity.MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
