package com.thundercsun.lomonosovv.presentation.base.disposer;

import io.reactivex.disposables.Disposable;

public interface Disposer {

    void bind(Disposable disposable);

    void bindAll(Disposable... disposables);

    void unbind(Disposable disposable);
}