package com.anggit97.daggerexample.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import com.anggit97.daggerexample.BaseActivity;
import com.anggit97.daggerexample.R;

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
    }
}
