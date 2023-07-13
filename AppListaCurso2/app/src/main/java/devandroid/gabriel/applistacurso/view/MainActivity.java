package devandroid.gabriel.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.gabriel.applistacurso.R;
import devandroid.gabriel.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;


    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNome_do_curso;
    EditText editTelefoneContato;

    Button btn_finalizar;
    Button btn_limpar;
    Button btn_salvar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Gabriel");
        pessoa.setSobreNome("Werner");
        pessoa.setCursoDesejado("Mecatrônica");
        pessoa.setTelefoneContato("980325571");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNome_do_curso = findViewById(R.id.editNome_do_curso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btn_limpar = findViewById(R.id.btn_limpar);
        btn_salvar = findViewById(R.id.btn_salvar);
        btn_finalizar = findViewById(R.id.btn_finalizar);


        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNome_do_curso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        // AÇÃO DO BOTÃO DE LIMPAR - LIMPA TODOS OS CAMPOS
        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNome_do_curso.setText("");
                editTelefoneContato.setText("");
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editNome_do_curso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this,"Seja Bem Vindo " + pessoa.toString(),Toast.LENGTH_LONG).show();


            }
        });

        // AÇÃO DO BOTÃO DE FINALIZAR - FECHA O APP
        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Dados cadastrados!",Toast.LENGTH_LONG).show();
                finish();
            }
        });




        Log.i("POOAndroid","Informações: " + pessoa.toString());
    }
}