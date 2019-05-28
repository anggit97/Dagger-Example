package com.anggit97.daggerexample.di.main;

import com.anggit97.daggerexample.ui.main.posts.PostFragment;
import com.anggit97.daggerexample.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
@Module
public abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostFragment contributePostFragment();
}
