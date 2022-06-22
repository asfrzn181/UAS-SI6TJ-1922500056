package ac.id.atmaluhur.mhs.uas19si056;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import java.util.HashMap;
public class EDosen extends AppCompatActivity {
    private EditText Enidn,Enama_dosen,Ejabatan,Egol_pang,Ekeahlian,Eprodi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edosen);

        Enidn = (EditText) findViewById(R.id.nidn);
        Enama_dosen = (EditText) findViewById(R.id.nama_dosen);
        Ejabatan = (EditText) findViewById(R.id.jabatan);
        Egol_pang = (EditText) findViewById(R.id.gol_pang);
        Ekeahlian = (EditText) findViewById(R.id.keahlian);
        Eprodi = (EditText) findViewById(R.id.prodi);
    }

    public void tambahData(View View){
        final String nidn = Enidn.getText().toString().trim();
        final String NmDosen = Enama_dosen.getText().toString().trim();
        final String jabatan = Ejabatan.getText().toString().trim();
        final String gol_pang = Egol_pang.getText().toString().trim();
        final String keahlian = Ekeahlian.getText().toString().trim();
        final String prodi = Eprodi.getText().toString().trim();

        class tambahData extends AsyncTask<Void, Void, String>{
            ProgressDialog load;
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                load = ProgressDialog.show(
                        EDosen.this, "Add...","Wait...",false,false );
            }
            @Override
            protected String doInBackground(Void... v){
                HashMap<String,String> params = new HashMap<>();
                params.put("nidn",nidn);
                params.put("nama_dosen",NmDosen);
                params.put("jabatan", jabatan);
                params.put("gol_pang",gol_pang);
                params.put("keahlian",keahlian);
                params.put("program_studi",prodi);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest("http://192.168.137.1/MobtechApi/tambah.php",params);
                return res;
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                load.dismiss();
                Toast.makeText(EDosen.this,s,Toast.LENGTH_LONG).show();
            }
        }
    tambahData td = new tambahData();
        td.execute();
    }
}