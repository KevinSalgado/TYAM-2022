package mx.uv.sbc.formappdemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private static String NAME_KEY = "name";
    private static String LAST_NAME_KEY = "lastname";
    private static String PHONE_KEY = "phone";
    private static String TAG = "MyFirstApp";
    private EditText edtName, edtLastname, edtPhone;

    FormViewModel formViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d (TAG, "OnCreate");
        setContentView (R.layout.activity_main);

        formViewModel = new ViewModelProvider (this).get (FormViewModel.class);

        edtName = findViewById (R.id.edtName);
        edtName.addTextChangedListener (new TextWatcher () {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged (Editable editable) {
                formViewModel.Name = editable.toString ();
            }
        });

        edtLastname = findViewById (R.id.edtLastname);
        edtLastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                formViewModel.LastName = editable.toString ();
            }
        });

        edtPhone = findViewById (R.id.edtPhone);
        edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                formViewModel.Phone = editable.toString ();
            }
        });

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

        edtName.setText (formViewModel.Name);
        edtLastname.setText (formViewModel.LastName);
        edtPhone.setText (formViewModel.Phone);
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
    protected void onRestart () {
        super.onRestart ();
        Log.d (TAG, "OnRestart");
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

//        outState.putString (NAME_KEY, edtName.getText ().toString ());
//        outState.putString (LAST_NAME_KEY, edtLastname.getText ().toString ());
//        outState.putString (PHONE_KEY, edtPhone.getText ().toString ());
    }

    @Override
    protected void onRestoreInstanceState (@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState (savedInstanceState);
        Log.d (TAG, "OnRestoreInstanceState");

//        String name = savedInstanceState.getString (NAME_KEY);
//        edtName.setText (name);
//
//        String lastname = savedInstanceState.getString (LAST_NAME_KEY);
//        edtLastname.setText (lastname);
//
//        String phone = savedInstanceState.getString (PHONE_KEY);
//        edtPhone.setText (phone);
    }
}
