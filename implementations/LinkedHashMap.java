package problems.ImageViewer.implementations;

import java.util.HashMap;
import java.util.List;

import problems.ImageViewer.interfaces.OrderedMap;

public class LinkedHashMap<K, V>  implements OrderedMap<K, V> {
    
    private HashMap<K, Node<V>> map;
    private DLinkedList<V> list;

    public LinkedHashMap() {
        map = new HashMap<>();
        list = new DLinkedList<>();
    }

    public List<V> getAll() {
        return this.list.getAll();
    }

    public V get(String key) {
        if (!map.containsKey(key)) {
            return null;
        }
        return map.get(key).data;
    }

    public V getPrev(String key) {
        if (!map.containsKey(key)) {
            return null;
        }
        if (map.get(key).prev == null) {
            return null;
        }
        return map.get(key).prev.data;
    }

    public V getNext(String key) {
        if (!map.containsKey(key)) {
            return null;
        }
        if (map.get(key).next == null) {
            return null;
        }
        return map.get(key).next.data;
    }

    public void put(K key, V metadata) {
        Node<V> in = new Node<>(metadata);
        this.list.addTail(in);
        map.put(key, in);
    }

    public boolean remove(String key) {
        Node<V> node = map.get(key);
        if (node == null) {
            return false;
        }
        return this.list.remove(node);
    }
}
