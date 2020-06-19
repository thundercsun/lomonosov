package com.thundercsun.lomonosovv.presentation.base.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.thundercsun.lomonosovv.app.App;
import com.thundercsun.lomonosovv.app.di.ViewModelFactory;
import com.thundercsun.lomonosovv.presentation.base.disposer.Disposer;
import com.thundercsun.lomonosovv.presentation.base.disposer.LifecycleDisposer;

import javax.inject.Inject;

@SuppressLint("Registered")
public class BaseActivity extends FragmentActivity {

    @Inject
    ViewModelFactory factory;

    private Disposer lifecycleDisposer = new LifecycleDisposer();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        App.component().inject(this);
    }

    protected <T extends ViewModel> T viewModel(Class<T> viewModelClass) {
        return ViewModelProviders.of(this, factory)
                .get(viewModelClass);
    }

    public Disposer disposer() {
        return lifecycleDisposer;
    }
}
