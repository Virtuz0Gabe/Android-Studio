package com.example.desafio_3.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.desafio_3.R;

public class Second extends AppCompatActivity {

    TextView int_numeroAcertos;
    TextView int_numeroErros;
    ProgressBar progress_acertos;
    ProgressBar progress_erros;
    ProgressBar progress_pulados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int acertos = intent.getIntExtra("acertos", 0);
        int erros = intent.getIntExtra("erros", 0);
        int pulos = intent.getIntExtra("pulos", 0);
        int totalQuestoes = intent.getIntExtra("totalQuestoes", 0);
        String strAcertos = Integer.toString(acertos);
        String strErros = Integer.toString(erros);

        int_numeroAcertos = findViewById(R.id.int_numeroAcertos);
        int_numeroErros = findViewById(R.id.int_numeroErros);
        progress_acertos = findViewById(R.id.progress_acertos);
        progress_erros = findViewById(R.id.progress_erros);
        progress_pulados = findViewById(R.id.progress_pulados);

        int_numeroAcertos.setText(strAcertos);
        int_numeroErros.setText(strErros);
        progress_acertos.setProgress(acertos);
        progress_acertos.setMax(totalQuestoes);
        progress_erros.setProgress(erros);
        progress_erros.setMax(totalQuestoes);
        progress_pulados.setProgress(pulos);
        progress_pulados.setMax(totalQuestoes);

    }
}