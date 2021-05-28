package problems.ImageViewer.implementations;

import java.util.ArrayList;
import java.util.List;

public class DLinkedList<V> {

    private Node<V> dummyHead;
    private Node<V> dummyTail;

    public DLinkedList() {
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

    public void addTail(Node<V> in) {
        Node<V> tailPrev = dummyTail.prev;
        tailPrev.next = in;
        in.next = dummyTail;
        in.prev = tailPrev;
        dummyTail.prev = in;
    }

    public boolean remove(Node<V> node) {
        if (dummyHead == dummyTail) {
            return false;
        }
        Node<V> prev = node.prev;
        Node<V> next = node.next;
        prev.next = next;
        next.prev = prev;
        return true;
    }
    
}
