package mx.uv.sbc.formappdemo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import mx.uv.sbc.formappdemo.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
//    private ActivityDetailsBinding viewBinding;
    ActivityDetailsBinding dataBinding;
    FormViewModel formViewModel;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setup viewBinding
//      viewBinding = ActivityDetailsBinding.inflate (getLayoutInflater ());
//      View view = viewBinding.getRoot ();
//      setContentView (view);

        //setup dataBinding
        dataBinding = DataBindingUtil.setContentView (this, R.layout.activity_details);

        //setup viewModel
        formViewModel = new ViewModelProvider(this).get (FormViewModel.class);

        Bundle bundle = getIntent ().getExtras ();
        if (bundle != null) {
            var a = bundle.getString ("NAME");
            var b = bundle.getString ("LASTNAME");
            var c = bundle.getString ("PHONE");

//            viewBinding.tvNameDetails.setText (a);
//            viewBinding.tvLastNameDetails.setText (b);
//            viewBinding.tvPhoneDetails.setText (c);

            formViewModel.Name = a;
            formViewModel.LastName = b;
            formViewModel.Phone = c;
        }

        dataBinding.setFormViewModel (formViewModel);
    }

}
