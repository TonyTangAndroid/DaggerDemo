package demo.tang.tony.usecase;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract class ThreadModule {

    @Binds
    abstract ThreadExecutor threadExecutor(JobExecutor jobExecutor);

    @Binds
    abstract UIThread providePostExecutionThread(MainThread mainThread);

}
