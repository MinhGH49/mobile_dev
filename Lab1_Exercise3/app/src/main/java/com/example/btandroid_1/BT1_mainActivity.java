package com.example.btandroid_1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.btandroid_1.databinding.ActivityBt1MainBinding;

import java.util.Date;

public class BT1_mainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBt1MainBinding binding;

    Toolbar navBar;
    Button btn_alert;

    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1_main);

        navBar = (Toolbar) findViewById(R.id.navBar);

        alert = new AlertDialog.Builder(this).create();

        btn_alert = (Button) findViewById(R.id.alert_button);

        btn_alert.setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;

        Date now = new Date();

        String msg ="Thời gian hiện tại là: " + now.toString();

        alert.setMessage(msg);
        alert.show();

    }
}