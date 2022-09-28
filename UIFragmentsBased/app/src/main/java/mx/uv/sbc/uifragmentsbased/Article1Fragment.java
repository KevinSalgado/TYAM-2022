package mx.uv.sbc.uifragmentsbased;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mx.uv.sbc.uifragmentsbased.databinding.Article1FragmentBinding;

public class Article1Fragment extends Fragment {
    private Article1FragmentBinding binding;

    // factory pattern
    public static Article1Fragment getInstance (Bundle params) {
        Article1Fragment fragment = new Article1Fragment ();
        fragment.setArguments (params);

        return fragment;
    }

    private BuyItButtonListener listener;

    public void setOnBuyItButtonListener (BuyItButtonListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = Article1FragmentBinding.inflate (inflater, container, false);
        return binding.getRoot ();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        var params = getArguments ();
        if (params != null) {
            var review = params.getString ("REVIEW", "");
            binding.tvArticle1Review.setText (review);
        }

        binding.btnBuyIt.setOnClickListener (v -> this.listener.clicked (1));
    }
}
