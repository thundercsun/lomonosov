package com.thundercsun.lomonosovv.presentation.base.output;

import com.thundercsun.lomonosovv.presentation.base.disposer.Disposer;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;

public abstract class ViewModelOutput<T> {

    public abstract void observe(Disposer disposer, Consumer<? super T> propertyConsumer);

    @Nullable
    public abstract T getOrNull();

    @NonNull
    public abstract T getOrError();
}
