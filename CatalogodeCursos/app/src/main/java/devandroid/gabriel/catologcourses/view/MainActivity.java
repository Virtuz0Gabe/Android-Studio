package devandroid.gabriel.catologcourses.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import devandroid.gabriel.catologcourses.R;
import devandroid.gabriel.catologcourses.UdacityService;
import devandroid.gabriel.catologcourses.models.Course;
import devandroid.gabriel.catologcourses.models.Instructor;
import devandroid.gabriel.catologcourses.models.UdacityCatalog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Gabes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UdacityService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UdacityService service = retrofit.create(UdacityService.class);
        Call<UdacityCatalog> requestCatalog = service.listCatalog();

        requestCatalog.enqueue(new Callback<UdacityCatalog>() {
            @Override
            public void onResponse(Call<UdacityCatalog> call, Response<UdacityCatalog> response) {
                if(!response.isSuccessful()){
                    Log.i(TAG, "Erro: " + response.code());
                } else {
                    UdacityCatalog catalog = response.body();
                    for (Course course : catalog.getCourses()){
                        Log.i(TAG, String.format("%s: %s", course.getTitle(), course.getSubtitle()));

                        for (Instructor instructor : course.getInstructors()){
                            Log.i(TAG, instructor.getName());
                        }
                        Log.i(TAG, "------------------------");
                    }
                }
            }

            @Override
            public void onFailure(Call<UdacityCatalog> call, Throwable t) {
                Log.e(TAG, "Erro: " + t.getMessage());
            }
        });
    }
}