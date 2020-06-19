package com.thundercsun.lomonosovv.app.di;

import android.app.Application;

import com.thundercsun.lomonosovv.app.di.module.NetworkModule;
import com.thundercsun.lomonosovv.app.di.module.RepositoryModule;
import com.thundercsun.lomonosovv.app.di.module.UseCaseModule;
import com.thundercsun.lomonosovv.app.di.module.ViewModelModule;
import com.thundercsun.lomonosovv.presentation.base.BaseViewModel;
import com.thundercsun.lomonosovv.presentation.base.view.BaseActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {NetworkModule.class, RepositoryModule.class, UseCaseModule.class, ViewModelModule.class})
@Singleton
public interface AppComponent {

    void injectsBaseViewModel(BaseViewModel baseViewModel);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder withApplication(Application application);

        AppComponent build();
    }

    void inject(BaseActivity mainActivity);
}
