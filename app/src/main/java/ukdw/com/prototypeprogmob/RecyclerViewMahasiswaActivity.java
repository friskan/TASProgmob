package ukdw.com.prototypeprogmob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import ukdw.com.prototypeprogmob.Adapter.MahasiswaAdapter;
import ukdw.com.prototypeprogmob.Model.Dosen;
import ukdw.com.prototypeprogmob.Model.Mahasiswa;
import ukdw.com.prototypeprogmob.Model.DefaultResult;
import ukdw.com.prototypeprogmob.Network.GetDataService;
import ukdw.com.prototypeprogmob.Network.RetrofitClientInstance;

public class RecyclerViewMahasiswaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;
    ProgressDialog progressDialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucreate,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecyclerViewMahasiswaActivity.this,CrudMahasiswaActivity.class);
            startActivity(intent);

        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_mhs);
        this.setTitle("Welcome Admin");

        //addData();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewMhs);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Mahasiswa>> call = service.getMhsAll("72170157");
        call.enqueue(new Callback<ArrayList<Mahasiswa>>() {
            @Override
            public void onResponse(Call<ArrayList<Mahasiswa>> call, Response<ArrayList<Mahasiswa>> response) {
                progressDialog.dismiss();

                mahasiswaArrayList = response.body();
                mahasiswaAdapter = new MahasiswaAdapter(response.body());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerViewMahasiswaActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(mahasiswaAdapter);
            }
            @Override
            public void onFailure(Call<ArrayList<Mahasiswa>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RecyclerViewMahasiswaActivity.this,"Error",Toast.LENGTH_SHORT);
            }
        });

        registerForContextMenu(recyclerView);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Mahasiswa mhs = mahasiswaArrayList.get(item.getGroupId());
        if (item.getTitle()== "Ubah Data Mahasiswa"){
            Intent intent = new Intent(RecyclerViewMahasiswaActivity.this, CrudMahasiswaActivity.class);
            intent.putExtra("id_mhs",mhs.getId());// -> ketika manggil Mha harus sama
            intent.putExtra("nama_mhs",mhs.getNamaMhs());
            intent.putExtra("nim",mhs.getNim());
            intent.putExtra("alamat_mhs",mhs.getAlamatMhs());
            intent.putExtra("email_mhs",mhs.getEmailMhs());
            intent.putExtra("foto_mhs",mhs.getFotoMhs());
            intent.putExtra("is_update",true);
            startActivity(intent);
        }else if(item.getTitle() == "Hapus Data Mahasiswa"){
            //Toast.makeText(RecyclerViewDaftarDosen.this,"Hapus",Toast.LENGTH_LONG).show();

            progressDialog = new ProgressDialog(RecyclerViewMahasiswaActivity.this);
            progressDialog.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_mahasiswa(
                    mhs.getId(), "72170157");
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(RecyclerViewMahasiswaActivity.this,"Berhasil Menghapus",Toast.LENGTH_SHORT).show();
                    recreate();
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(RecyclerViewMahasiswaActivity.this,"Gagal Hapus",Toast.LENGTH_SHORT).show();
                }
            });
        }

        return super.onContextItemSelected(item);
    }







       /* recyclerView = findViewById(R.id.recyclerViewMhs);
        mahasiswaAdapter = new MahasiswaAdapter(mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(RecyclerViewMahasiswaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mahasiswaAdapter);
    }

    public void klikCrudMahasiswa(View view)
    {
        Intent i = new Intent(RecyclerViewMahasiswaActivity.this,CrudMahasiswaActivity.class);
        startActivity(i);
    }
    private void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("72170121",
                "Meyke Vanny Saptenno", "vanny@email.com", "Jl. Lavender No. 18"));
        mahasiswaArrayList.add(new Mahasiswa("72170145",
                "Elisa Novensiana", "elisa@email.com", "Jl. Lily No. 4"));
        mahasiswaArrayList.add(new Mahasiswa("72170157",
                "Friska F. Nainggolan", "friska@email.com", "Jl. Tulip No. 8"));
    }*/

}
