package com.anggit97.daggerexample.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anggit97.daggerexample.R;
import com.anggit97.daggerexample.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: View is ready..");

        viewModel = ViewModelProviders.of(this, factory).get(ProfileViewModel.class);
    }
}
