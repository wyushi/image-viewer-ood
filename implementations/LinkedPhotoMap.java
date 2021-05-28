package problems.ImageViewer.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import problems.ImageViewer.interfaces.ImageMetadata;
import problems.ImageViewer.interfaces.ImageStore;

public class LinkedPhotoMap implements ImageStore {
    private HashMap<String, Node<ImageMetadata>> map;
    private Node<ImageMetadata> dummyHead;
    private Node<ImageMetadata> dummyTail;

    public LinkedPhotoMap() {
        map = new HashMap<>();
        dummyHead = new Node<>(null);
        dummyTail = new Node<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public List<ImageMetadata> getAllPhotos() {
        List<ImageMetadata> ans = new ArrayList<>();
        if (dummyHead == dummyTail) {
            return ans;
        }
        Node<ImageMetadata> curr = dummyHead.next;
        while (curr != dummyTail) {
            ans.add(curr.data);
            curr = curr.next;
        }
        return ans;
    }

    public ImageMetadata getPhoto(String imgId) {
        if (!map.containsKey(imgId)) {
            return null;
        }
        return map.get(imgId).data;
    }

    public ImageMetadata getPrev(String imgId) {
        if (!map.containsKey(imgId)) {
            return null;
        }
        if (map.get(imgId).prev == null) {
            return null;
        }
        return map.get(imgId).prev.data;
    }

    public ImageMetadata getNext(String imgId) {
        if (!map.containsKey(imgId)) {
            return null;
        }
        if (map.get(imgId).next == null) {
            return null;
        }
        return map.get(imgId).next.data;
    }

    public void addPhoto(ImageMetadata metadata) {
        Node<ImageMetadata> in = new Node<>(metadata);
        Node<ImageMetadata> tailPrev = dummyTail.prev;
        tailPrev.next = in;
        in.next = dummyTail;
        in.prev = tailPrev;
        dummyTail.prev = in;
        map.put(metadata.getImgId(), in);
    }

    public boolean removePhoto(String imgId) {
        if (dummyHead == dummyTail) {
            return false;
        }
        if (map.get(imgId) == null) {
            return false;
        }
        Node<ImageMetadata> node = map.get(imgId);
        Node<ImageMetadata> prev = node.prev;
        Node<ImageMetadata> next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(imgId);
        return true;
    }
}
