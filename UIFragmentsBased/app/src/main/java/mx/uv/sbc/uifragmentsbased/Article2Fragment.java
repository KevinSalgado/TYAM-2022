package mx.uv.sbc.uifragmentsbased;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mx.uv.sbc.uifragmentsbased.databinding.Article2FragmentBinding;

public class Article2Fragment extends Fragment {
    private Article2FragmentBinding binding;

    //factory pattern
    public static Article2Fragment getInstance (Bundle params) {
        Article2Fragment fragment = new Article2Fragment ();
        fragment.setArguments (params);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = Article2FragmentBinding.inflate (inflater, container, false);
        return binding.getRoot ();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle params = getArguments ();
        if (params != null) {
            Toast.makeText (getActivity(),
                    params.getString ("PARAM2", ""),
                    Toast.LENGTH_LONG).show ();
        }
    }
}
