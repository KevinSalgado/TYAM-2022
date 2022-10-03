package mx.uv.fiee.iinf.tyam.memegrafia.fragments;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import mx.uv.fiee.iinf.tyam.memegrafia.MainActivity;
import mx.uv.fiee.iinf.tyam.memegrafia.R;
import mx.uv.fiee.iinf.tyam.memegrafia.databinding.FragmentMemeDetailsBinding;

public class MemeDetailsFragment extends Fragment {
    private FragmentMemeDetailsBinding binding;

    public static MemeDetailsFragment newInstance (int index) {
        MemeDetailsFragment fragment = new MemeDetailsFragment ();

        Bundle b = new Bundle ();
        b.putInt (MainActivity.KEY, index);
        fragment.setArguments (b);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMemeDetailsBinding.inflate (inflater, container, false);
        return binding.getRoot ();
    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);

        Bundle b = getArguments ();
        if (b == null) return;
        int index = b.getInt (MainActivity.KEY);

        FragmentActivity activity = getActivity ();
        if (activity == null) return;

        String name             = activity.getResources ().getStringArray (R.array.names) [index];
        String description      = activity.getResources ().getStringArray (R.array.descriptions) [index];
        String url              = activity.getResources ().getStringArray (R.array.urls) [index];
        TypedArray typedArray   = activity.getResources ().obtainTypedArray (R.array.images);
        Drawable meme           = typedArray.getDrawable (index);

        binding.tvName.setText (name);
        binding.tvDescription.setText (description);
        binding.tvUrl.setText (url);

        binding.memeImage.setImageDrawable (meme);
        typedArray.recycle ();
    }
}
