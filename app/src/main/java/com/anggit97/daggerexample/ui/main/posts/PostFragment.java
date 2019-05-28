package com.anggit97.daggerexample.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anggit97.daggerexample.R;
import com.anggit97.daggerexample.model.Post;
import com.anggit97.daggerexample.ui.main.Resource;
import com.anggit97.daggerexample.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerFragment;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public class PostFragment extends DaggerFragment {

    private static final String TAG = "PostFragment";

    private PostViewModel postViewModel;

    private RecyclerView recyclerView;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: view created");

        recyclerView = view.findViewById(R.id.recycler_view);

        postViewModel = ViewModelProviders.of(this, providerFactory).get(PostViewModel.class);

        subscribeToObserver();
    }

    private void subscribeToObserver() {
        postViewModel.observePosts().removeObservers(getViewLifecycleOwner());
        postViewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if (listResource != null) {
                    Log.d(TAG, "onChanged: " + listResource.data);
                }
            }
        });
    }
}
