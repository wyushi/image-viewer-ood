package problems.ImageViewer.implementations;

import problems.ImageViewer.interfaces.ImageMetadata;

public class ImageMetadataImpl implements ImageMetadata {


    public static ImageMetadata create(String id, String url) {
        return new ImageMetadataImpl(id, url);
    }

    private final String imgId;
    private final String imgUrl;

    public ImageMetadataImpl(String id, String url) {
        this.imgId = id;
        this.imgUrl = url;
    }

    @Override
    public String getImgId() {
        return this.imgId;
    }

    @Override
    public String getImgURL() {
        return this.imgUrl;
    }
}
