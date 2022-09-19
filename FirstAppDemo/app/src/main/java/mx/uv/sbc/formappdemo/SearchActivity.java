package mx.uv.sbc.formappdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.uv.sbc.formappdemo.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {
    private ActivitySearchBinding binding;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate (getLayoutInflater ());
        var view = binding.getRoot ();
        setContentView (view);

        binding.btnBack.setOnClickListener (v -> {
            var searched = binding.edtSearch.getText().toString ();

            if (searched.equals ("")) {
                setResult (RESULT_CANCELED);
            } else {
                Intent intent = new Intent ();
                intent.putExtra ("NAME", searched);
                setResult (RESULT_OK, intent);
            }

            finish ();
        });
    }
}
