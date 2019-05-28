package com.anggit97.daggerexample.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.anggit97.daggerexample.BaseActivity;
import com.anggit97.daggerexample.R;
import com.anggit97.daggerexample.ui.main.profile.ProfileFragment;

import androidx.annotation.Nullable;

/**
 * Created by Anggit Prayogo on 5/28/19.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show();
        testFragment();
    }

    private void testFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ProfileFragment(), "Profile Fragment")
                .commit();
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
}
