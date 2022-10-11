package mx.uv.sbc.lorempicsumgallery;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mx.uv.sbc.lorempicsumgallery.api.LoremPicsumService;
import mx.uv.sbc.lorempicsumgallery.models.ImageResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String TITLE = "LoremPicsum Client";
    public static final String BASE_URL = "https://picsum.photos";
    public static final int COLUMNS = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

        if (getSupportActionBar () != null) {
            getSupportActionBar().setTitle (TITLE);
        }

        RecyclerView recyclerView = findViewById (R.id.rvGallery);
        recyclerView.addItemDecoration (new DividerItemDecoration (getBaseContext (), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager (new LinearLayoutManager(getBaseContext ()));

        var retrofit = new Retrofit.Builder ()
                .addConverterFactory (GsonConverterFactory.create ())
                .baseUrl (BASE_URL)
                .build ();

        var service = retrofit.create (LoremPicsumService.class);

        Call<List<ImageResult>> call = service.getImages ();
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<ImageResult>> call, Response<List<ImageResult>> response) {
                var result = response.body ();
                recyclerView.setAdapter (new GalleryAdapter (getBaseContext(), result));
            }

            @Override
            public void onFailure(Call<List<ImageResult>> call, Throwable t) {
                Log.e ("PKAT", "Error getting images from " + BASE_URL, t);
            }
        });
    }
}
