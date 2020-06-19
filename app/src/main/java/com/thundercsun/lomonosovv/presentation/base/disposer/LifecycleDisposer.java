package com.thundercsun.lomonosovv.presentation.base.disposer;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class LifecycleDisposer implements Disposer {

    private final CompositeDisposable compositeDisposable;

    public LifecycleDisposer() {
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void bind(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void bindAll(Disposable... disposables) {
        compositeDisposable.addAll(disposables);
    }

    @Override
    public void unbind(Disposable disposable) {
        compositeDisposable.remove(disposable);
    }

    public void disposeAll() {
        compositeDisposable.clear();
    }
}
