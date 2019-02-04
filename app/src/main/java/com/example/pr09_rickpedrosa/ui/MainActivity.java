package com.example.pr09_rickpedrosa.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.example.pr09_rickpedrosa.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // navController = Navigation.findNavController(this, R.id.navHostFragment);
    }
}
