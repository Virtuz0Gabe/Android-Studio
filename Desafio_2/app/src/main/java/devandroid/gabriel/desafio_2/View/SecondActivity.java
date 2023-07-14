package devandroid.gabriel.desafio_2.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.gabriel.desafio_2.R;

public class SecondActivity extends AppCompatActivity {

    private static final Object TAG = "Gabes";
    TextView txt_name_field;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txt_name_field = findViewById(R.id.txt_name_field);
        Intent intent = getIntent();
        Log.i((String) TAG, intent.getStringExtra("name"));
        String nome = intent.getStringExtra("name");
        txt_name_field.setText("Seja Bem Vindo " + nome);
    }
}
