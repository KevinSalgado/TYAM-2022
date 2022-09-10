package mx.uv.sbc.trigonometriccalc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TrigonometricCalcApp";
    private static final int DEGREE_45 = 45;
    private static final int DEGREE_90 = 90;
    private static final int DEGREE_180 = 180;

    private TrigonometricCalcViewModel viewModel;

    RadioGroup rgGrados;
    TextView tvResultados;
    ImageView imageView;
    Bitmap foo = null;
    int grados = -1;
    Funcs func = null;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        setTitle (R.string.app_name);

        viewModel = new ViewModelProvider (this).get (TrigonometricCalcViewModel.class);

        tvResultados = findViewById (R.id.tvResultados);
        imageView = findViewById (R.id.ivGrados);

        rgGrados = findViewById (R.id.rgGrados);
        rgGrados.setOnCheckedChangeListener ((radioGroup, i) -> {
            switch (i) {
                case (R.id.rb45):
                    foo = BitmapFactory.decodeResource (getResources (), R.drawable.g45);
                    grados = DEGREE_45;
                    break;
                case (R.id.rb90):
                    foo = BitmapFactory.decodeResource (getResources (), R.drawable.g90);
                    grados = DEGREE_90;
                    break;
                case (R.id.rb180):
                    foo = BitmapFactory.decodeResource (getResources (), R.drawable.g180);
                    grados = DEGREE_180;
                    break;
            }

            double result = Maths.calcular (grados, func);
            tvResultados.setText (String.format (Locale.US, "%.16f", result));
            imageView.setImageBitmap (foo);

            viewModel.Degree_Selected = i;
            viewModel.Func_Selected = func;
            viewModel.Resultado = result;
            viewModel.Image = foo;
        });

        RadioGroup rgFuncs = findViewById (R.id.rgFuncs);
        rgFuncs.setOnCheckedChangeListener ((radioGroup, i) -> {

            imageView.setImageResource (android.R.color.transparent);
            Log.d (TAG, "Cleaning ImageView");

            tvResultados.setText ("");
            Log.d (TAG, "Cleaning Resultados");

            rgGrados.clearCheck ();
            Log.d (TAG, "Cleaning Radio Group Grados");

            switch (i) {
                case (R.id.rbSIN):
                    func = Funcs.Sin;
                    break;
                case (R.id.rbCOS):
                    func = Funcs.Cos;
                    break;
                case (R.id.rbTAN):
                    func = Funcs.Tan;
                    break;
            }

        });
    }

    @Override
    protected void onResume () {
        super.onResume ();
        if (viewModel.Degree_Selected > 0) {
            rgGrados.check (viewModel.Degree_Selected);
        }
    }
}
