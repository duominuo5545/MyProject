package com.rich.lambda;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by hanwang206326 on 16/1/17.
 */
public interface Collection2<T> extends Collection<T> {
    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<T> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
                action.accept(each.next());
            }
        }
    }
}
