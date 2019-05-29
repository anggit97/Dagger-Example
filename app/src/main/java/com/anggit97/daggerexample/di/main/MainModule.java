package com.anggit97.daggerexample.di.main;

import com.anggit97.daggerexample.network.main.MainApi;
import com.anggit97.daggerexample.ui.main.posts.PostsRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
@Module
public class MainModule {

    @Provides
    static PostsRecyclerAdapter providePostRecyclerAdapter(){
        return new PostsRecyclerAdapter();
    }

    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }
}
