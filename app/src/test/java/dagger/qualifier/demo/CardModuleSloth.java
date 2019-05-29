package dagger.qualifier.demo;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
class CardModuleSloth {


    @Provides
    static String sloth() {
        return "sloth";
    }

    @Named("tony")
    @Provides
    static String xxx() {
        return "tony";
    }

    @ScarlettString
    @Provides
    static String scarlett() {
        return "scarlett";
    }

    @ScarlettString222
    @Provides
    static String scarlett1() {
        return "scarlett1";
    }


    //elinimate amberguity
    //消除歧义

}