package com.ridgid.oss.common.cache;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface Cache<K, V> {

    int size();

    void clear();

    boolean isEmpty();

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean containsKey(K key);

    void forEach(BiConsumer<? super K, ? super V> action);

    Stream<Map.Entry<K, V>> stream();

    Stream<K> streamKeys();

    Stream<V> streamValues();

    default Optional<V> get(K key) {
        return Optional.ofNullable(getOrDefault(key, null));
    }

    V getOrDefault(K key, V defaultValue);

    V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction);

    V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);

    V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);

    V put(K key, V value);

    void putAll(Map<? extends K, ? extends V> m);

    V putIfAbsent(K key, V value);

    V remove(K key);

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean replace(K key, V oldValue, V newValue);

    void replaceAll(BiFunction<? super K, ? super V, ? extends V> function);

    V replace(K key, V value);

    V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction);

}
