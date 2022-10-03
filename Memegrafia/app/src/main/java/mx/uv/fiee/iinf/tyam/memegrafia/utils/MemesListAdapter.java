package mx.uv.fiee.iinf.tyam.memegrafia.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import mx.uv.fiee.iinf.tyam.memegrafia.databinding.RecyclerListItemBinding;

public class MemesListAdapter extends RecyclerView.Adapter<MemesListAdapter.MemesViewHolder> {
    private final Context context;
    private final String [] names;
    private final TypedArray memes;
    private final OnMemeTouchedListener listener;

    private RecyclerListItemBinding binding;

    public MemesListAdapter(Context context, String[] names, TypedArray memes, OnMemeTouchedListener listener) {
        this.context = context;
        this.names = names;
        this.memes = memes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MemesViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        binding = RecyclerListItemBinding.inflate (LayoutInflater.from (context), viewGroup, false);
        return new MemesViewHolder (binding.getRoot ());
    }

    @Override
    public void onBindViewHolder (@NonNull MemesViewHolder memesViewHolder, int i) {
        memesViewHolder.bind (names [i], memes.getDrawable (i));

        memesViewHolder.itemView.setOnClickListener (view -> {
            if (listener != null) listener.onMemeTouched (i);
        });
    }

    @Override
    public int getItemCount () {
        return names.length;
    }

    class MemesViewHolder extends RecyclerView.ViewHolder {

        MemesViewHolder (@NonNull View itemView) {
            super (itemView);
        }

        void bind (String text, Drawable drawable) {
            binding.memeImage.setImageDrawable (drawable);
            binding.name.setText (text);
        }

    }

}

