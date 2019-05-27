package com.anggit97.daggerexample.di.auth;

import com.anggit97.daggerexample.di.ViewModelKey;
import com.anggit97.daggerexample.ui.auth.AuthViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Anggit Prayogo on 5/27/19.
 */
@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel authViewModel);
}
