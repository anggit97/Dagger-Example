package com.anggit97.daggerexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.anggit97.daggerexample.model.User;
import com.anggit97.daggerexample.ui.auth.AuthActivity;
import com.anggit97.daggerexample.ui.auth.AuthResource;
import com.anggit97.daggerexample.ui.main.MainActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    public void subscribeObservers() {
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING:
                            break;
                        case ERROR:
                            break;
                        case AUTHENTICATED:
                            break;
                        case NOT_AUTHENTICATED:
                            navLoginScreen();
                            break;
                    }
                }
            }
        });
    }

    private void navLoginScreen() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
