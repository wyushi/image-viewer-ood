package problems.ImageViewer.implementations;

import java.util.List;

import problems.ImageViewer.interfaces.ImageMetadata;
import problems.ImageViewer.interfaces.ImageStore;
import problems.ImageViewer.interfaces.OrderedMap;

public class ImageStoreImpl implements ImageStore {

    private final OrderedMap<String, ImageMetadata> store;

    public ImageStoreImpl() {
        this.store = new LinkedHashMap<>();
    }

    @Override
    public List<ImageMetadata> getAllPhotos() {
        return this.store.getAll();
    }

    @Override
    public ImageMetadata getPhoto(String imgId) {
        return this.store.get(imgId);
    }

    @Override
    public ImageMetadata getPrev(String imgId) {
        return this.store.getPrev(imgId);
    }

    @Override
    public ImageMetadata getNext(String imgId) {
        return this.store.getNext(imgId);
    }

    @Override
    public void addPhoto(ImageMetadata metadata) {
        this.store.put(metadata.getImgId(), metadata);
    }

    @Override
    public boolean removePhoto(String imgId) {
        return this.store.remove(imgId);
    }
    
}
