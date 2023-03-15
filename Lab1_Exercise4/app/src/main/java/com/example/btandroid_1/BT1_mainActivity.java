package com.example.btandroid_1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.KeyEvent;
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

public class BT1_mainActivity extends AppCompatActivity implements View.OnKeyListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBt1MainBinding binding;

    Toolbar navBar;

    EditText edit;

    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1_main);

        navBar = (Toolbar) findViewById(R.id.navBar);

        alert = new AlertDialog.Builder(this).create();

        edit = (EditText) findViewById(R.id.edit_text);

//        btn_alert.setOnClickListener(this::onClick);

        edit.setOnKeyListener(this::onKey);

    }
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        System.out.println(Integer.toString(i));
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    String msg = edit.getText().toString();
                    alert.setMessage(msg);
                    alert.show();
                    return true;
                }
                return false;
    }
}