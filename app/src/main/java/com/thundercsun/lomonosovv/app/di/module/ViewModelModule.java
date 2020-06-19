package com.thundercsun.lomonosovv.app.di.module;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.thundercsun.lomonosovv.app.di.ViewModelFactory;
import com.thundercsun.lomonosovv.app.di.ViewModelKey;
import com.thundercsun.lomonosovv.presentation.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(includes = UseCaseModule.class)
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel mainViewModel(MainViewModel mainViewModel);

    @NonNull
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
