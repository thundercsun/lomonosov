package com.thundercsun.lomonosovv.presentation.base.output;

import com.thundercsun.lomonosovv.presentation.base.disposer.Disposer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;

public abstract class MutableViewModelOutput<T> extends ViewModelOutput<T> implements Observer<T> {

    public abstract void setValue(T newValue);

    public abstract void setValueDistinct(T newValue);

    public abstract void subscribe(Disposer disposer, Observable<? extends T> observable);

    public abstract void subscribe(Disposer disposer, Single<? extends T> single);

    public abstract Observable<T> toObservable();

    public static <T> MutableViewModelOutput<T> create() {
        return MutableViewModelOutputImpl.create();
    }

    public static <T> MutableViewModelOutput<T> create(T initialValue) {
        return MutableViewModelOutputImpl.create(initialValue);
    }
}

