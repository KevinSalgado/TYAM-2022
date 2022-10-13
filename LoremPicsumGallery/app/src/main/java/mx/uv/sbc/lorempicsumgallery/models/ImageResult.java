package mx.uv.sbc.lorempicsumgallery.models;

import com.google.gson.annotations.SerializedName;

public class ImageResult {

    public String author;
    public String url;

    @SerializedName ("download_url")
    public String downloadUrl;

}
