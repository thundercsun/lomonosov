package com.thundercsun.lomonosovv.app;

import android.app.Application;

import com.thundercsun.lomonosovv.app.di.AppComponent;
import com.thundercsun.lomonosovv.app.di.DaggerAppComponent;

public class App extends Application {

    private static App instance;
    private static AppComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerAppComponent
                .builder()
                .withApplication(this)
                .build();
    }

    public static App instance() {
        return instance;
    }

    public static AppComponent component() {
        return component;
    }
}
