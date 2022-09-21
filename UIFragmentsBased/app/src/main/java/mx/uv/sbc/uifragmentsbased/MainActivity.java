package mx.uv.sbc.uifragmentsbased;

import static androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import mx.uv.sbc.uifragmentsbased.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen (this);

        super.onCreate (savedInstanceState);
        binding = ActivityMainBinding.inflate (getLayoutInflater ());
        var view = binding.getRoot ();
        setContentView (view);

        setSupportActionBar (binding.toolbar);
        if (getSupportActionBar () != null) {
            getSupportActionBar ().setTitle (R.string.toolbar_title);
        }

        binding.rgArticles.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.rbArticle1) {
                var params = new Bundle ();
                params.putString ("PARAM1", "PARAM1");
                Article1Fragment fragment = Article1Fragment.getInstance (params);

                getSupportFragmentManager ()
                        .beginTransaction ()
                        .setTransition (TRANSIT_FRAGMENT_FADE)
                        .replace (R.id.myContainer, fragment)
                        .commit ();
            }

            if (i == R.id.rbArticle2) {
                var params = new Bundle ();
                params.putString ("PARAM2", "PARAM2");
                Article2Fragment fragment = Article2Fragment.getInstance (params);

                getSupportFragmentManager ()
                        .beginTransaction ()
                        .setTransition (TRANSIT_FRAGMENT_FADE)
                        .replace (R.id.myContainer, fragment)
                        .commit ();
            }
        });
    }

}