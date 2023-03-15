package com.example.btandroid_1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.btandroid_1.databinding.ActivityBt1MainBinding;

public class BT1_mainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBt1MainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1_main);

        Toolbar navBar = (Toolbar) findViewById(R.id.navBar);
    }

}