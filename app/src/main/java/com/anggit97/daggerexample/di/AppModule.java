package com.anggit97.daggerexample.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import com.anggit97.daggerexample.R;
import com.anggit97.daggerexample.util.Constant;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anggit Prayogo on 5/26/19.
 */
@Module
public class AppModule{

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions(){
        return RequestOptions.placeholderOf(R.drawable.white_background).error(R.drawable.white_background);
    }

    @Singleton
    @Provides
    static RequestManager provideGlide(Application application, RequestOptions requestOptions){
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static Drawable provideDrawable(Application application){
        return application.getDrawable(R.drawable.logo);
    }
}
