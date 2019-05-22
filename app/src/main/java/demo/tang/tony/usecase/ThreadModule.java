package demo.tang.tony.usecase;

import dagger.Binds;
import dagger.Module;
import demo.tang.tony.com.daggerdemo.AppScope;

@Module
public abstract class ThreadModule {

    @AppScope
    @Binds
    abstract ThreadExecutor threadExecutor(JobExecutor jobExecutor);

    @AppScope
    @Binds
    abstract UIThread providePostExecutionThread(MainThread mainThread);

}
