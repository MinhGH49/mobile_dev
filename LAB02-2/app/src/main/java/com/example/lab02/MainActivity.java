package com.example.lab02;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private AppBarConfiguration appBarConfiguration;

    Button bred;
    Button bgre;
    Button bblu;
    Button bgra;

    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        bred = (Button) findViewById(R.id.b_red);
        bgre = (Button) findViewById(R.id.b_gre);
        bblu = (Button) findViewById(R.id.b_blu);
        bgra = (Button) findViewById(R.id.b_gra);
        main = (LinearLayout) findViewById(R.id.main);

        bred.setOnClickListener(this::onClick);
        bgre.setOnClickListener(this::onClick);
        bblu.setOnClickListener(this::onClick);
        bgra.setOnClickListener(this::onClick);

    }


    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        switch (btn.getText().toString()) {
            case "red":
                main.setBackgroundColor(getColor(R.color.red));
            break;
            case "green":
                main.setBackgroundColor(getColor(R.color.green));
                break;
            case "blue":
                main.setBackgroundColor(getColor(R.color.blue));
                break;
            case "gray":
                main.setBackgroundColor(getColor(R.color.gray));
                break;
        }


    }

}