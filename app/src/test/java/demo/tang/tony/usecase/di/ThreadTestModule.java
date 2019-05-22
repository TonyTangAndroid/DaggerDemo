package demo.tang.tony.usecase.di;

import dagger.Binds;
import dagger.Module;
import demo.tang.tony.com.daggerdemo.AppScope;
import demo.tang.tony.usecase.JobExecutor;
import demo.tang.tony.usecase.MainThread;
import demo.tang.tony.usecase.ThreadExecutor;
import demo.tang.tony.usecase.UIThread;

@Module
public abstract class ThreadTestModule {

    @Binds
    abstract ThreadExecutor threadExecutor(JobExecutor jobExecutor);

    @Binds
    abstract UIThread providePostExecutionThread(MainThread mainThread);

}
