package ac.id.atmaluhur.mhs.uas19si056;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {

    public TextView tampilData;
    private DataDariApi jsonPlaceHolderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tampilData = findViewById(R.id.tampilData);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.137.1/mobtechApi/") //IP Hotspot Laptop
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderAPI = retrofit.create(DataDariApi.class);
        getPosts();
    }
    public void EDosen(View View){
        Intent i = new Intent(MainActivity.this,EDosen.class);
        startActivity(i);
    }
    private void getPosts(){
        Map<String, String> parameters = new HashMap<>();
        Call<List<DosenPost>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<DosenPost>>() {
            @Override
            public void onResponse(Call<List<DosenPost>> call, Response<List<DosenPost>> response){
                if(!response.isSuccessful()){
                    tampilData.setText("code: "+ response.code());
                    return;
                }
                List<DosenPost> posts = response.body();
                for (DosenPost post:posts){
                    String content = "";
                    content += "NIDN: " +post.getNidn() + "\n";
                    content += "Nama: " +post.getNamaDosen() + "\n";
                    content += "Jabatan: " +post.getJabatan() + "\n";
                    content += "Golongan Pangkat: " +post.getGolPang() + "\n";
                    content += "Keahlian: " +post.getKeahlian() + "\n";
                    content += "Program Studi: " +post.getProdi() + "\n";
                    content += "======================================\n";
                    tampilData.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<DosenPost>> call, Throwable t){
                tampilData.setText(t.getMessage());
            }
        });
    }
}