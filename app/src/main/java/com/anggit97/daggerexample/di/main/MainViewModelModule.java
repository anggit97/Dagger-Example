package com.anggit97.daggerexample.di.main;

import com.anggit97.daggerexample.di.ViewModelKey;
import com.anggit97.daggerexample.ui.main.profile.ProfileViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
@Module
public abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);
}
