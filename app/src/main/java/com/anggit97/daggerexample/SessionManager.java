package com.anggit97.daggerexample;

import android.util.Log;

import com.anggit97.daggerexample.model.User;
import com.anggit97.daggerexample.ui.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/**
 * Created by Anggit Prayogo on 5/27/19.
 */
@Singleton
public class SessionManager {

    private static final String TAG = "SessionManager";

    private MediatorLiveData<AuthResource<User>> cacheUser = new MediatorLiveData<>();

    @Inject
    public SessionManager() {
    }

    public void authenticateWithId(final LiveData<AuthResource<User>> source){
        if (cacheUser != null){
            cacheUser.setValue(AuthResource.loading((User)null));
            cacheUser.addSource(source, new Observer<AuthResource<User>>() {
                @Override
                public void onChanged(AuthResource<User> userAuthResource) {
                    cacheUser.setValue(userAuthResource);
                    cacheUser.removeSource(source);
                }
            });
        }else{
            Log.d(TAG, "authenticateWithId: Previous Session Detected");
        }
    }

    public void logout(){
        Log.d(TAG, "logout:");
        cacheUser.setValue(AuthResource.<User>logout());
    }

    public LiveData<AuthResource<User>> getAuthUser(){
        return cacheUser;
    }
}
