package com.anggit97.daggerexample.ui.main;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.anggit97.daggerexample.BaseActivity;
import com.anggit97.daggerexample.R;
import com.anggit97.daggerexample.ui.main.posts.PostFragment;
import com.anggit97.daggerexample.ui.main.profile.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        initNavController();
    }

    private void initNavController() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_logout:
                sessionManager.logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_profile: {
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.profileScreen);
                break;
            }
            case R.id.nav_post: {
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.postScreen);
                break;
            }
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
