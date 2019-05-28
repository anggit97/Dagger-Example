package com.anggit97.daggerexample.network.main;

import com.anggit97.daggerexample.model.Post;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public interface MainApi {

    @GET("posts")
    Flowable<List<Post>> getPostsFromUser(
            @Query("userId") int userId
    );
}
