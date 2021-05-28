package problems.ImageViewer.interfaces;

import java.util.List;

public interface OrderedMap<K, V> {
    List<V> getAll();
    V get(String key);
    V getPrev(String key);
    V getNext(String key);

    void put(K key, V metadata);
    boolean remove(String key);
}
