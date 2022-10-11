package mx.uv.sbc.lorempicsumgallery.api;

import java.util.List;

import mx.uv.sbc.lorempicsumgallery.models.ImageResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LoremPicsumService {

    @GET ("/v2/list")
    Call<List<ImageResult>> getImages ();

}
