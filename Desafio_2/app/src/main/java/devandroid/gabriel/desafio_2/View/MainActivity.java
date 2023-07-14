package devandroid.gabriel.desafio_2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;

import devandroid.gabriel.desafio_2.Models.Pessoa;
import devandroid.gabriel.desafio_2.R;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    EditText edit_txt_name;
    Button btn_prosseguir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pessoa pessoa = new Pessoa();
        edit_txt_name = findViewById(R.id.edit_txt_name);
        btn_prosseguir = findViewById(R.id.btn_prosseguir);

        btn_prosseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setNome(edit_txt_name.getText().toString());

                if (pessoa.getNome() == "" ){
                    Toast.makeText(MainActivity.this,"Você deve preencher o campo Nome ",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pessoa.getNome().length() < 3) {
                    Toast.makeText(MainActivity.this,"Você deve preencher com um nome Válido",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this,"Seja Bem Vindo " + pessoa.getNome(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", pessoa.getNome());
                startActivity(intent);
            }
        });
    }
}