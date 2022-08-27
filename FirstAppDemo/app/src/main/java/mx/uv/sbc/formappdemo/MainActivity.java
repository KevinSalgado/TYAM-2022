package mx.uv.sbc.formappdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
}
