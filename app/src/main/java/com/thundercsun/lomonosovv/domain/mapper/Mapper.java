package com.thundercsun.lomonosovv.domain.mapper;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

public abstract class Mapper<From, To> {

    public To map(From item) {
        if (item == null) throw new IllegalStateException("Nullable item to map");

        return mapImpl(item);
    }

    public List<To> mapAll(List<From> items) {
        return Stream.of(items)
                .map(this::mapImpl)
                .collect(Collectors.toList());
    }

    abstract protected To mapImpl(From item);

}
