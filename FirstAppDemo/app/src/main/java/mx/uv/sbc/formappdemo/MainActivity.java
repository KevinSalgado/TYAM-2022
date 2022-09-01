package mx.uv.sbc.formappdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private static String TAG = "MyFirstApp";

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);

        EditText edtName = findViewById (R.id.edtName);
        EditText edtLastname = findViewById (R.id.edtLastname);
        EditText edtPhone = findViewById (R.id.edtPhone);

        Button btnSend = findViewById (R.id.btnSend);
        btnSend.setOnClickListener (view -> {
            Toast.makeText (getBaseContext (), edtName.getText().toString (), Toast.LENGTH_LONG).show ();
        });

        Button btnClear = findViewById (R.id.btnClear);
    }

    @Override
    protected void onStart () {
        super.onStart ();
        Log.d (TAG, "OnStart");
    }

    @Override
    protected void onResume () {
        super.onResume ();
        Log.d (TAG, "OnResume");
    }

    @Override
    protected void onPause () {
        super.onPause ();
        Log.d (TAG, "OnPause");
    }

    @Override
    protected void onStop () {
        super.onStop ();
        Log.d (TAG, "OnStop");
    }

    @Override
    protected void onDestroy () {
        super.onDestroy ();
        Log.d (TAG, "OnDestroy");
    }

    @Override
    protected void onSaveInstanceState (@NonNull Bundle outState) {
        super.onSaveInstanceState (outState);
        Log.d (TAG, "OnSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d (TAG, "OnRestoreInstanceState");
    }
}
