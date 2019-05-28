package com.anggit97.daggerexample.ui.auth;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.anggit97.daggerexample.R;
import com.anggit97.daggerexample.model.User;
import com.anggit97.daggerexample.ui.main.MainActivity;
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
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        etUserId = findViewById(R.id.user_id_input);
        btnLogin = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.progress_bar);

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
        viewModel.observeAuthState().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING:
                            showProgress(true);
                            break;
                        case ERROR:
                            showProgress(false);
                            Toast.makeText(AuthActivity.this, "Did you enter number between 1 - 9?", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onChanged: " + userAuthResource.message +
                                    "\n Did you enter number between 1 - 9?");
                            break;
                        case AUTHENTICATED:
                            Log.d(TAG, "onChanged: Berhasil login " + userAuthResource.data.getEmail());
                            Toast.makeText(AuthActivity.this, "Berhasil Login " + userAuthResource.data.getEmail(), Toast.LENGTH_SHORT).show();
                            showProgress(false);
                            navMainScreen();
                            break;
                        case NOT_AUTHENTICATED:
                            Log.d(TAG, "onChanged: Not Authenticate");
                            Toast.makeText(AuthActivity.this, "Logout.", Toast.LENGTH_SHORT).show();
                            showProgress(false);
                            break;
                    }
                }
            }
        });
    }

    private void showProgress(boolean isLoading) {
        progressBar.setIndeterminate(isLoading);
        if (isLoading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void navMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
