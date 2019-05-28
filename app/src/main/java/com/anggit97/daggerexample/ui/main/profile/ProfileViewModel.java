package com.anggit97.daggerexample.ui.main.profile;

import android.util.Log;

import com.anggit97.daggerexample.SessionManager;
import com.anggit97.daggerexample.model.User;
import com.anggit97.daggerexample.ui.auth.AuthResource;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        Log.d(TAG, "ProfileViewModel: is ready");
    }

    public LiveData<AuthResource<User>> getAuthenticateUser(){
        return sessionManager.getAuthUser();
    }
}
