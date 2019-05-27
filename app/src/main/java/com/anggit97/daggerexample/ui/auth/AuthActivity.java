package com.anggit97.daggerexample.ui.auth;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.anggit97.daggerexample.R;
import com.anggit97.daggerexample.model.User;
import com.anggit97.daggerexample.viewmodels.ViewModelProviderFactory;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

    private AuthViewModel viewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    RequestManager requestManager;

    @Inject
    Drawable logo;

    private EditText etUserId;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        etUserId = findViewById(R.id.user_id_input);
        btnLogin = findViewById(R.id.login_button);

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AuthViewModel.class);

        requestManager.load(logo).into((ImageView) findViewById(R.id.login_logo));

        subscribToUser();

        onClickListener();
    }

    private void onClickListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUserId.getText().toString().isEmpty()) {
                    Toast.makeText(AuthActivity.this, "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }
                viewModel.authenticateWithId(Integer.parseInt(etUserId.getText().toString()));
            }
        });
    }

    private void subscribToUser() {
        viewModel.observeUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null){
                    Log.d(TAG, "onChanged: "+user.getEmail());
                }
            }
        });
    }
}
