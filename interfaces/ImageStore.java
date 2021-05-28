package problems.ImageViewer.interfaces;

import java.util.List;

public interface ImageStore {
    List<ImageMetadata> getAllPhotos();
    ImageMetadata getPhoto(String imgId);

    // opt 1: store keeps internal state for curr image
    // opt 2: curr get managed by caller, and passed in (check)
    ImageMetadata getPrev(String imgId);
    ImageMetadata getNext(String imgId);

    void addPhoto(ImageMetadata in);
    boolean removePhoto(String imgId);
}
