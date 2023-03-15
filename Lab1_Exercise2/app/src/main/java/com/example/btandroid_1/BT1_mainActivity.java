package com.example.btandroid_1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

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

public class BT1_mainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBt1MainBinding binding;

    Toolbar navBar;
    EditText phone;
    Button btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1_main);

        navBar = (Toolbar) findViewById(R.id.navBar);

        phone = (EditText) findViewById(R.id.phone_number);

        btn_call = (Button) findViewById(R.id.call_button);
        btn_call.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        Intent call_intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone.getText().toString()));
        call_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            startActivity(call_intent);
        }

    }
}