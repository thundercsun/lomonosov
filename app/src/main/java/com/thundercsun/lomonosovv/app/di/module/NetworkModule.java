package com.thundercsun.lomonosovv.app.di.module;

import com.thundercsun.lomonosovv.Core;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Core provideCore() {
        return Core.instance();
    }
}
