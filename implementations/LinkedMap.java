package problems.ImageViewer.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import problems.ImageViewer.interfaces.OrderedMap;

public class LinkedMap<K, V>  implements OrderedMap<K, V> {
    private HashMap<K, Node<V>> map;
    private Node<V> dummyHead;
    private Node<V> dummyTail;

    public LinkedMap() {
        map = new HashMap<>();
        dummyHead = new Node<>(null);
        dummyTail = new Node<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public List<V> getAll() {
        List<V> ans = new ArrayList<>();
        if (dummyHead == dummyTail) {
            return ans;
        }
        Node<V> curr = dummyHead.next;
        while (curr != dummyTail) {
            ans.add(curr.data);
            curr = curr.next;
        }
        return ans;
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
        Node<V> tailPrev = dummyTail.prev;
        tailPrev.next = in;
        in.next = dummyTail;
        in.prev = tailPrev;
        dummyTail.prev = in;
        map.put(key, in);
    }

    public boolean remove(String key) {
        if (dummyHead == dummyTail) {
            return false;
        }
        if (map.get(key) == null) {
            return false;
        }
        Node<V> node = map.get(key);
        Node<V> prev = node.prev;
        Node<V> next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(key);
        return true;
    }
}
