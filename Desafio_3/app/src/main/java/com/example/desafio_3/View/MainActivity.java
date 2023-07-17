package com.example.desafio_3.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.desafio_3.Models.Question;
import com.example.desafio_3.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Gabes";
    private boolean questoesAdicionadas = false;
    private List<Question> listaDeQuestoes;

    TextView txt_label_numero_questao;
    TextView txt_enunciado_questao;
    Button btn_opc_1;
    Button btn_opc_2;
    Button btn_opc_3;
    Button btn_opc_4;

    Button btn_pular;
    private void adicionarPerguntas () {
        Question question1 = new Question("O Android é baseado em qual sistema operacional?",
                Arrays.asList("Linux", "Windows", "MacOS", "Ubuntu"), 0);
        listaDeQuestoes.add(question1);
        Question question2 = new Question("Qual dos métodos seguintes não faz parte do ciclo de vida de uma activity?",
                Arrays.asList("onCreate()", "onStop()", "onReload()", "onRestart()"),2);
        listaDeQuestoes.add(question2);
        Question question3 = new Question("Qual componente do Android é responsável por armazenar dados de forma persistente?",
                Arrays.asList("Activity", "Fragment", "Service", "SharedPreferences"), 3);
        listaDeQuestoes.add(question3);
        Question question4 = new Question("Qual método é chamado quando uma Activity é interrompida, mas ainda está visível para o usuário?",
                Arrays.asList("onPause()", "onStop()", "onResume()", "onRestart()"), 1);
        listaDeQuestoes.add(question4);
        Question question5 = new Question("Qual classe é usada para exibir mensagens de pequena duração na parte inferior da tela?",
                Arrays.asList("Toast", "Snackbar", "Dialog", "Notification"), 1);
        listaDeQuestoes.add(question5);
    }
    public void alternativaCorreta (int alternativa) {
        Question question = listaDeQuestoes.get(indexQuestaoAtual);
        int resposta = question.getRespostaCerta();
        SharedPreferences sharedPreferences = getSharedPreferences("desempenho", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int acertos = sharedPreferences.getInt("acertos", 0);
        int erros = sharedPreferences.getInt("erros", 0);
        int pulos = sharedPreferences.getInt("pulos", 0);

        if (alternativa == resposta) {
            Log.i(TAG, "Você acertou!");
            acertos ++;
            editor.putInt("acertos", acertos);
        } else if (alternativa == 4) {
            Log.i(TAG, "Você Pulou uma questão");
            pulos ++;
            editor.putInt("pulos", pulos);
        } else {
            Log.i(TAG, "Você errou!");
            erros ++;
            editor.putInt("erros", erros);
        }
        editor.apply();
        Log.w(TAG, "Enviando para próxima página    \nquestão atual " + indexQuestaoAtual + "listadeQuestões.size() " + (listaDeQuestoes.size() - 1));
        if (indexQuestaoAtual >= listaDeQuestoes.size() - 1){
            Intent intent = new Intent(this, Second.class);
            intent.putExtra("acertos", acertos);
            intent.putExtra("erros", erros);
            intent.putExtra("pulos", pulos);
            intent.putExtra("totalQuestoes", listaDeQuestoes.size());
            startActivity(intent);
            return;
        }
        indexQuestaoAtual++;
        exibirQuestao();
    }
    public void exibirQuestao () {
        if (indexQuestaoAtual < listaDeQuestoes.size()){
            Question question = listaDeQuestoes.get(indexQuestaoAtual);
            List<String> alternativas = question.getAlternativas();
            txt_label_numero_questao.setText(String.format(Locale.getDefault(), "Questão número %d de %d", (indexQuestaoAtual + 1), listaDeQuestoes.size()));
            txt_enunciado_questao.setText((question.getEnunciado()));
            btn_opc_1.setText(alternativas.get(0));
            btn_opc_2.setText(alternativas.get(1));
            btn_opc_3.setText(alternativas.get(2));
            btn_opc_4.setText(alternativas.get(3));
        }
    }
    private int indexQuestaoAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SHARED PREFERENCES ==========
        SharedPreferences sharedPreferences = getSharedPreferences("desempenho", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("acertos", 0);
        editor.putInt("erros", 0);
        editor.putInt("pulos", 0);
        editor.apply();

        listaDeQuestoes = new ArrayList<>();
        txt_label_numero_questao = findViewById(R.id.txt_label_numero_questao);
        txt_enunciado_questao = findViewById(R.id.txt_enunciado_questao);
        btn_opc_1 = findViewById(R.id.btn_opc_1);
        btn_opc_2 = findViewById(R.id.btn_opc_2);
        btn_opc_3 = findViewById(R.id.btn_opc_3);
        btn_opc_4 = findViewById(R.id.btn_opc_4);
        btn_pular = findViewById(R.id.btn_pular);

        if (!questoesAdicionadas) {
            adicionarPerguntas();
            questoesAdicionadas = true;
        }
        btn_opc_1.setOnClickListener(view -> alternativaCorreta(0));
        btn_opc_2.setOnClickListener(view -> alternativaCorreta(1));
        btn_opc_3.setOnClickListener(view -> alternativaCorreta(2));
        btn_opc_4.setOnClickListener(view -> alternativaCorreta(3));
        btn_pular.setOnClickListener(view -> alternativaCorreta(4));

        exibirQuestao();
        }

    }
