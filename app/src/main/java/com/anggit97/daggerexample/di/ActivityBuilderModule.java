package com.anggit97.daggerexample.di;

import com.anggit97.daggerexample.di.auth.AuthModule;
import com.anggit97.daggerexample.di.auth.AuthViewModelModule;
import com.anggit97.daggerexample.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Anggit Prayogo on 5/26/19.
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();
}
