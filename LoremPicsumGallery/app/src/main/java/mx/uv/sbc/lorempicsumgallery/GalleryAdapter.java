package mx.uv.sbc.lorempicsumgallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.uv.sbc.lorempicsumgallery.models.ImageResult;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder> {
    private final Context context;
    private final List<ImageResult> images;

    public GalleryAdapter (Context context, List<ImageResult> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        var view = LayoutInflater.from (context).inflate (R.layout.row_item, parent, false);
        return new GalleryViewHolder (view);
    }

    @Override
    public int getItemCount() {
        return images.size ();
    }

    @Override
    public void onBindViewHolder (@NonNull GalleryViewHolder holder, int position) {
        var image = images.get (position);
        holder.bind (image.author, image.url, image.downloadUrl);
    }

}

class GalleryViewHolder extends RecyclerView.ViewHolder {
    private final TextView tvAuthor;
    private final TextView tvURL;
    private final ImageView ivLoremPic;

    public GalleryViewHolder (@NonNull View itemView) {
        super (itemView);
        tvAuthor = itemView.findViewById (R.id.tvAuthor);
        tvURL = itemView.findViewById (R.id.tvURL);
        ivLoremPic = itemView.findViewById (R.id.ivLoremPic);
    }

    public void bind (String author, String url, String downloadUrl) {
        tvAuthor.setText (author);
        tvURL.setText (url);

        Picasso.get ()
                .load (downloadUrl)
                .placeholder (R.drawable.placeholder)
                .fit ()
                .centerCrop ()
                .into (ivLoremPic);
    }
}


