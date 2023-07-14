package devandroid.gabriel.desafio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Gabes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate em andamento");
        Toast.makeText(MainActivity.this,"onCreate em Andamento", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onRestart em andamento");
        Toast.makeText(MainActivity.this,"onRestart em Andamento", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onStart em andamento");
        Toast.makeText(MainActivity.this,"onStart em Andamento", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onStop em andamento");
        Toast.makeText(MainActivity.this,"onStop em Andamento", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"onDestroy em andamento");
        Toast.makeText(MainActivity.this,"onDestroy em Andamento", Toast.LENGTH_SHORT).show();
        super.onDestroy();
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onPause em andamento");
        Toast.makeText(MainActivity.this,"onPause em Andamento", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onResume em andamento");
        Toast.makeText(MainActivity.this,"onResume em Andamento", Toast.LENGTH_SHORT).show();
    }
}