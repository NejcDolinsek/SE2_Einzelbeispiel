package com.example.se2_einzelbeispiel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.se2_einzelbeispiel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.se2_einzelbeispiel.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        //Button for the Task 2 (Ordering and deleting of the prime numbers)
        Button BtnCalc = findViewById(R. id. BtnCalc);
        BtnCalc.setOnClickListener(v -> {

            EditText InputText = findViewById(R. id. EditTextInput);
            TextView AnswerCalc = findViewById(R. id. AntwortServer);

            String Matrikelnummer = OrderAndDeletePrimeNumbers.matNumberWithOutPrimeNumbers(InputText);
            AnswerCalc.setText("Die Matrikelnummer in reihenfolge ohne Primzahlen: "+Matrikelnummer);

        });





    }
}