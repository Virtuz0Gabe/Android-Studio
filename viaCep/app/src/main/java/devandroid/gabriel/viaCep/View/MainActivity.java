package devandroid.gabriel.viaCep.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import devandroid.gabriel.viaCep.Models.Endereco;
import devandroid.gabriel.viaCep.Models.ViaCepService;
import devandroid.gabriel.viaCep.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Gabes";
    Endereco endereco;

    // BOTOES
    Button btn_buscar;

    // EDIT TEXT
    EditText editCep;
    TextView txt_logradouro;
    TextView txt_complemento;
    TextView txt_bairo;
    TextView txt_uf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_buscar = findViewById(R.id.btn_buscar);
        editCep = findViewById(R.id.editCep);

        txt_logradouro = findViewById(R.id.txt_logradouro);
        txt_complemento = findViewById(R.id.txt_complemento);
        txt_bairo = findViewById(R.id.txt_bairro);
        txt_uf = findViewById(R.id.txt_uf);


        // REALIZAR A BUSCA DO ENDEREÇO
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cep = editCep.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ViaCepService.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ViaCepService service = retrofit.create(ViaCepService.class);
                Call<Endereco> requestEndereco = service.endereco(cep);

                requestEndereco.enqueue(new Callback<Endereco>() {
                    @Override
                    public void onResponse(Call<Endereco> call, Response<Endereco> response) {
                        if (!response.isSuccessful()) {
                            Log.i(TAG, "Erro: " + response.code());
                        } else {
                            Endereco resposta = response.body();
                            Log.i(TAG, String.format("%s : %s", resposta.getBairro(), resposta.getUf()));
                            txt_logradouro.setText(resposta.getLogradouro());
                            txt_complemento.setText(resposta.getComplemento());
                            txt_bairo.setText(resposta.getBairro());
                            txt_uf.setText(resposta.getUf());
                        }
                    }

                    @Override
                    public void onFailure(Call<Endereco> call, Throwable t) {
                        Log.e(TAG, "Erro: " + t.getMessage());
                    }
                });
            }
        });
    }
}