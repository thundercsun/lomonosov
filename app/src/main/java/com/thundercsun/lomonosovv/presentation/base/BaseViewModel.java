package com.thundercsun.lomonosovv.presentation.base;

import androidx.annotation.CallSuper;
import androidx.lifecycle.ViewModel;

import com.thundercsun.lomonosovv.app.App;
import com.thundercsun.lomonosovv.presentation.base.disposer.Disposer;
import com.thundercsun.lomonosovv.presentation.base.disposer.LifecycleDisposer;
import com.thundercsun.lomonosovv.presentation.base.output.MutableViewModelOutput;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {

    private final LifecycleDisposer lifecycleDisposer;

    public BaseViewModel() {
        this.lifecycleDisposer = new LifecycleDisposer();
        App.component().injectsBaseViewModel(this);
    }

    @CallSuper
    @Override
    protected void onCleared() {
        lifecycleDisposer.disposeAll();
    }

    protected final Disposable bind(Disposable disposable) {
        lifecycleDisposer.bind(disposable);
        return disposable;
    }

    protected final void unbind(Disposable disposable) {
        lifecycleDisposer.unbind(disposable);
    }

    protected final Disposer disposer() {
        return lifecycleDisposer;
    }

    protected final <T> MutableViewModelOutput<T> output(Observable<? extends T> observable) {
        MutableViewModelOutput<T> output = MutableViewModelOutput.create();
        output.subscribe(disposer(), observable);
        return output;
    }

    protected final <T> MutableViewModelOutput output(Single<? extends T> single) {
        MutableViewModelOutput<T> output = MutableViewModelOutput.create();
        output.subscribe(disposer(), single);
        return output;
    }
}