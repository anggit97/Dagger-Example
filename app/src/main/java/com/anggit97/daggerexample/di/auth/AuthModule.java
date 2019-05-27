package com.anggit97.daggerexample.di.auth;

import com.anggit97.daggerexample.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Anggit Prayogo on 5/27/19.
 */
@Module
public class AuthModule {

    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }
}
