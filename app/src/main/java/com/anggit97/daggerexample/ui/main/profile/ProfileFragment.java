package com.anggit97.daggerexample.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anggit97.daggerexample.R;
import com.anggit97.daggerexample.model.User;
import com.anggit97.daggerexample.ui.auth.AuthResource;
import com.anggit97.daggerexample.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public class ProfileFragment extends DaggerFragment {

    private static final String TAG = "ProfileFragment";

    @Inject
    ViewModelProviderFactory factory;

    ProfileViewModel viewModel;

    private TextView tvEmail, tvUsername, tvWebsite;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: View is ready..");

        tvEmail = view.findViewById(R.id.email);
        tvUsername = view.findViewById(R.id.username);
        tvWebsite = view.findViewById(R.id.website);

        viewModel = ViewModelProviders.of(this, factory).get(ProfileViewModel.class);

        observeAuthUser();
    }

    private void observeAuthUser() {
        viewModel.getAuthenticateUser().removeObservers(getViewLifecycleOwner());
        viewModel.getAuthenticateUser().observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case AUTHENTICATED:
                            showDetailUser(userAuthResource.data);
                            break;
                        case ERROR:
                            showError(userAuthResource.message);
                            break;
                    }
                }
            }
        });
    }

    private void showDetailUser(User data) {
        tvEmail.setText(data.getEmail());
        tvUsername.setText(data.getName());
        tvWebsite.setText(data.getWebsite());
    }

    private void showError(String message) {
        tvEmail.setText(message);
        tvUsername.setText(message);
        tvWebsite.setText(message);
    }
}
