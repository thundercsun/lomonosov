package com.thundercsun.lomonosovv.presentation.base.output;

import androidx.annotation.Nullable;

import com.thundercsun.lomonosovv.app.function.Func1;
import com.thundercsun.lomonosovv.presentation.base.disposer.Disposer;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

class MutableViewModelOutputImpl<T> extends MutableViewModelOutput<T> {

    private final BehaviorSubject<T> valueSubject;
    private final Func1<Observable<T>, Observable<T>> observableTransformation;

    private MutableViewModelOutputImpl(@Nullable Func1<Observable<T>, Observable<T>> observableTransformation) {
        this.valueSubject = BehaviorSubject.create();
        this.observableTransformation = observableTransformation;
    }

    private MutableViewModelOutputImpl(
            T initialValue,
            @Nullable Func1<Observable<T>, Observable<T>> observableTransformation
    ) {
        this.valueSubject = BehaviorSubject.createDefault(initialValue);
        this.observableTransformation = observableTransformation;
    }

    @Override
    public void setValue(T newValue) {
        valueSubject.onNext(newValue);
    }

    @Override
    public void setValueDistinct(T newValue) {
        if (valueSubject.hasValue()) {
            T currentValue = valueSubject.getValue();
            if (!currentValue.equals(newValue)) {
                setValue(newValue);
            }
        } else {
            setValue(newValue);
        }
    }

    @Override
    public void subscribe(Disposer disposer, Observable<? extends T> observable) {
        Disposable disposable = observable.subscribe(this::onNext);
        disposer.bind(disposable);
    }

    @Override
    public void subscribe(Disposer disposer, Single<? extends T> single) {
        Disposable disposable = single.subscribe(this::onNext);
        disposer.bind(disposable);
    }

    @Override
    public void observe(Disposer disposer, Consumer<? super T> propertyConsumer) {
        Observable<T> transformedObservable = transformedObservable();
        Disposable consumerDisposable = subscribe(transformedObservable, propertyConsumer);
        disposer.bind(consumerDisposable);
    }

    @Override
    public T getOrNull() {
        if (valueSubject.hasValue()) {
            return valueSubject.getValue();
        } else {
            return null;
        }
    }

    @Override
    public T getOrError() {
        if (valueSubject.hasValue()) {
            return valueSubject.getValue();
        } else {
            throw new NoValueException();
        }
    }

    @Override
    public Observable<T> toObservable() {
        return transformedObservable();
    }

    @Override
    public void onSubscribe(Disposable d) {
        valueSubject.onSubscribe(d);
    }

    @Override
    public void onNext(T t) {
        valueSubject.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        valueSubject.onError(e);
    }

    @Override
    public void onComplete() {
        valueSubject.onComplete();
    }

    private Observable<T> transformedObservable() {
        if (observableTransformation == null) {
            return valueSubject;
        } else {
            return observableTransformation.call(valueSubject);
        }
    }

    private Disposable subscribe(Observable<T> observable, Consumer<? super T> propertyConsumer) {
        return observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(propertyConsumer);
    }

    public static <T> MutableViewModelOutputImpl<T> create() {
        return new MutableViewModelOutputImpl<>(null);
    }

    public static <T> MutableViewModelOutputImpl<T> create(T initialValue) {
        return new MutableViewModelOutputImpl<>(initialValue, null);
    }
}