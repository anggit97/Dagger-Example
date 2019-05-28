package com.anggit97.daggerexample.ui.main.profile;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    @Inject
    public ProfileViewModel() {
        Log.d(TAG, "ProfileViewModel: is ready");
    }
}
