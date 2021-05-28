package problems.ImageViewer;

import java.util.List;

import problems.ImageViewer.implementations.ImageMetadataImpl;
import problems.ImageViewer.implementations.ImageStoreImpl;
import problems.ImageViewer.interfaces.ImageMetadata;
import problems.ImageViewer.interfaces.ImageStore;

public class App {

    public static void main(String[] args) {
        ImageStore store = new ImageStoreImpl();
        ImageMetadata i1 = ImageMetadataImpl.create("1", "/images/1");
        store.addPhoto(i1);
        ImageMetadata i2 = ImageMetadataImpl.create("2", "/images/2");
        store.addPhoto(i2);
        ImageMetadata i3 = ImageMetadataImpl.create("3", "/images/3");
        store.addPhoto(i3);

        // all photo screen
        List<ImageMetadata> allImages = store.getAllPhotos();
        assert allImages.size() == 3;
        // click a photo
        ImageMetadata metadata = allImages.get(1);
        assert metadata != null;
        // one photo screen
        ImageMetadata curr = store.getPhoto(metadata.getImgId());
        assert curr != null;
        // click next
        curr = store.getNext(curr.getImgId());
        assert curr != null;
        
        curr = store.getNext(curr.getImgId());
        assert curr == null;
        // click next
        curr = store.getPrev(metadata.getImgId());
        assert curr != null;
    }
}
