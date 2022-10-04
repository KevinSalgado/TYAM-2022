package mx.uv.fiee.iinf.tyam.memegrafia.fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import mx.uv.fiee.iinf.tyam.memegrafia.R;
import mx.uv.fiee.iinf.tyam.memegrafia.databinding.FragmentMemesListBinding;
import mx.uv.fiee.iinf.tyam.memegrafia.utils.MemesListAdapter;
import mx.uv.fiee.iinf.tyam.memegrafia.utils.OnMemeTouchedListener;

public class MemesListFragment extends Fragment {
    private FragmentMemesListBinding binding;
    private OnMemeTouchedListener listener;

    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach (context);

        if (context instanceof OnMemeTouchedListener) {
            listener = (OnMemeTouchedListener) context;
        } else {
            throw new ClassCastException ("Must implement OnMemeTouchedListener first!");
        }
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMemesListBinding.inflate (inflater, container, false);
        return binding.getRoot ();
    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);

        FragmentActivity activity = getActivity ();
        if (activity == null) return;

        String [] namesArray = activity.getResources ().getStringArray (R.array.names);
        TypedArray memesArray = activity.getResources ().obtainTypedArray (R.array.images);

        binding.recview.setLayoutManager (new GridLayoutManager(getContext (),
                2, GridLayoutManager.VERTICAL, false));

        binding.recview.setAdapter (new MemesListAdapter (getContext (), namesArray, memesArray, listener));
   }
}


