package com.example.se2_einzelbeispiel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.se2_einzelbeispiel.databinding.ActivityMainBinding;
import java.io.IOException;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.se2_einzelbeispiel.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Button for the Task 2 (Ordering and deleting of the prime numbers)
        Button BtnCalc = findViewById(R. id. BtnCalc);
        BtnCalc.setOnClickListener(v -> {

            EditText InputText = findViewById(R. id. EditTextInput);
            TextView AnswerCalc = findViewById(R. id. AntwortServer);

            String Matrikelnummer = OrderAndDeletePrimeNumbers.matNumberWithOutPrimeNumbers(InputText);
            AnswerCalc.setText("Die Matrikelnummer in reihenfolge ohne Primzahlen: "+Matrikelnummer);

        });

        //Button to execute the Tcp Client
        Button BtnServer = findViewById(R. id. BtnSend);
        BtnServer.setOnClickListener(v -> {
            EditText InputText = findViewById(R. id. EditTextInput);
            TextView AnswerServer = findViewById(R. id. AntwortServer);

            String matrikelnummer = InputText.getText().toString();

            Flowable.fromCallable(()->SendToServer(matrikelnummer))
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.single())
                    .subscribe(Answer -> runOnUiThread(()->AnswerServer.setText(Answer)));

        });
    }
    public String SendToServer (String Matrikelnummer) throws IOException {
        TcpClient tcpClient = new TcpClient(Matrikelnummer);
        tcpClient.run();
        return tcpClient.getServerAnswer();
    }
}