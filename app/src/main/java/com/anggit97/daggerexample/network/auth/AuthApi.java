package com.anggit97.daggerexample.network.auth;

import com.anggit97.daggerexample.model.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Anggit Prayogo on 5/27/19.
 */
public interface AuthApi {

    @GET("users/{user_id}")
    Flowable<User> getUsers(@Path("user_id") String userId);
}
