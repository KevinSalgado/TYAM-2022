package mx.uv.sbc.uifragmentsbased;

import static androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import mx.uv.sbc.uifragmentsbased.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppDatabase database;

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

        database = Room.databaseBuilder (getApplicationContext (), AppDatabase.class,
                "Reviews.db").addCallback (new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                new Thread (() -> populateDatabase ()).start ();
            }
        }).build ();

        binding.rgArticles.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.rbArticle1) {

                new Thread (() -> {
                    var id = 1;
                    var result = database.reviewDAO().findReviewById (id);

                    var params = new Bundle ();
                    params.putString ("REVIEW", result.Review);
                    Article1Fragment fragment = Article1Fragment.getInstance (params);
                    fragment.setOnBuyItButtonListener (articleId -> {
                        Bundle bundle = new Bundle ();
                        bundle.putString ("ITEMSELECTED", "Article 1");
                        var cartFragment = CartFragment.getInstance (bundle);

                        getSupportFragmentManager ()
                                .beginTransaction ()
                                .setTransition (TRANSIT_FRAGMENT_FADE)
                                .replace (R.id.myContainer, cartFragment)
                                .commit ();
                    });

                    runOnUiThread (() -> getSupportFragmentManager ()
                            .beginTransaction ()
                            .setTransition (TRANSIT_FRAGMENT_FADE)
                            .replace (R.id.myContainer, fragment)
                            .commit ());
                }).start ();
            }

            if (i == R.id.rbArticle2) {
                new Thread(() -> {
                    var id = 2;
                    var result = database.reviewDAO().findReviewById (id);

                    var params = new Bundle ();
                    params.putString ("REVIEW", result.Review);
                    Article2Fragment fragment = Article2Fragment.getInstance (params);
                    fragment.setOnBuyItButtonListener (articleId -> {
                        Bundle bundle = new Bundle ();
                        bundle.putString ("ITEMSELECTED", "Article 2");
                        var cartFragment = CartFragment.getInstance (bundle);

                        getSupportFragmentManager ()
                                .beginTransaction ()
                                .setTransition (TRANSIT_FRAGMENT_FADE)
                                .replace (R.id.myContainer, cartFragment)
                                .commit ();
                    });

                    runOnUiThread(() -> getSupportFragmentManager ()
                            .beginTransaction ()
                            .setTransition (TRANSIT_FRAGMENT_FADE)
                            .replace (R.id.myContainer, fragment)
                            .commit ());
                }).start ();
            }
        });
    }

    private void populateDatabase () {
        var reviews1 = new Reviews ();
        reviews1.ArticleId = 1;
        reviews1.Review = getResources().getString (R.string.review_article1);

        var reviews2 = new Reviews ();
        reviews2.ArticleId = 2;
        reviews2.Review = getResources().getString (R.string.review_article2);

        new Thread (() -> database.reviewDAO().insertAll (reviews1, reviews2)).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate (R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuSettings) {
            Toast.makeText (getBaseContext (), "Settings", Toast.LENGTH_LONG).show ();
        }

        return super.onOptionsItemSelected(item);
    }
}