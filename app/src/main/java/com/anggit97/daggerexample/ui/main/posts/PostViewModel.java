package com.anggit97.daggerexample.ui.main.posts;

import android.util.Log;

import com.anggit97.daggerexample.SessionManager;
import com.anggit97.daggerexample.network.main.MainApi;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public class PostViewModel extends ViewModel {

    private static final String TAG = "PostViewModel";

    private final SessionManager sessionManager;
    private final MainApi mainApi;

    @Inject
    public PostViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;

        Log.d(TAG, "PostViewModel: PostView is working..");
    }
}
