package ukdw.com.prototypeprogmob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.prototypeprogmob.Adapter.DosenAdapter;
import ukdw.com.prototypeprogmob.Model.DefaultResult;
import ukdw.com.prototypeprogmob.Model.Dosen;
import ukdw.com.prototypeprogmob.Network.GetDataService;
import ukdw.com.prototypeprogmob.Network.RetrofitClientInstance;

public class RecyclerViewDosenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen> dosenArrayList;
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
            Intent intent = new Intent(RecyclerViewDosenActivity.this,CrudDosenActivity.class);
            startActivity(intent);
        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        this.setTitle("Welcome Admin");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Dosen>> call = service.getDosenAll("72170157");
        call.enqueue(new Callback<ArrayList<Dosen>>() {
            @Override
            public void onResponse(Call<ArrayList<Dosen>> call, Response<ArrayList<Dosen>> response) {
                progressDialog.dismiss();

                dosenArrayList = response.body();
                dosenAdapter = new DosenAdapter(response.body());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerViewDosenActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(dosenAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Dosen>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RecyclerViewDosenActivity.this,"Error",Toast.LENGTH_SHORT);
            }
        });

        registerForContextMenu(recyclerView);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Dosen dosen = dosenArrayList.get(item.getGroupId());
        if (item.getTitle()== "Ubah Data Dosen"){
            Intent intent = new Intent(RecyclerViewDosenActivity.this, CrudDosenActivity.class);
            intent.putExtra("id_dosen",dosen.getId());// -> ketika manggil Dosen harus sama
            intent.putExtra("nama",dosen.getNama());
            intent.putExtra("nidn",dosen.getNidn());
            intent.putExtra("alamat",dosen.getAlamat());
            intent.putExtra("email",dosen.getEmail());
            intent.putExtra("gelar",dosen.getGelar());
            intent.putExtra("foto",dosen.getFoto());
            intent.putExtra("is_update",true);
            startActivity(intent);
        }else if(item.getTitle() == "Hapus Data Dosen"){
            //Toast.makeText(RecyclerViewDaftarDosen.this,"Hapus",Toast.LENGTH_LONG).show();

            progressDialog = new ProgressDialog(RecyclerViewDosenActivity.this);
            progressDialog.show();

            GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<DefaultResult> call = service.delete_dosen(
                    dosen.getId(), "72170157");
            call.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    progressDialog.dismiss();
                    Toast.makeText(RecyclerViewDosenActivity.this,"Berhasil Menghapus",Toast.LENGTH_SHORT).show();
                    recreate();
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(RecyclerViewDosenActivity.this,"Gagal Hapus",Toast.LENGTH_SHORT).show();
                }
            });
        }

        return super.onContextItemSelected(item);
    }

        /*ImageButton imgButtonCrudDosen = (ImageButton) findViewById(R.id.imgButtonCrudDosen);
        imgButtonCrudDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecyclerViewDosenActivity.this,CrudDosenActivity.class);
                startActivity(i);
            }
        });*/



        //addData();

        /*recyclerView = findViewById(R.id.recyclerView);
        dosenAdapter = new DosenAdapter(dosenArrayList);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(RecyclerViewDosenActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dosenAdapter);
    }

    public void klikCrudDosen(View view)
    {
        Intent i = new Intent(RecyclerViewDosenActivity.this,CrudDosenActivity.class);
        startActivity(i);
    }
    private void addData(){
        dosenArrayList = new ArrayList<>();
        dosenArrayList.add(new Dosen("10211",
                "Katon Wijana", "Master of Computer Sains", "katon@email.com",
                "Jl. Mawar No. 11"));
        dosenArrayList.add(new Dosen("20134",
                "Jong Jek Siang", "Magister Sains", "jjs@email.com",
                "Jl. Melati No. 9"));
        dosenArrayList.add(new Dosen("40322",
                "Yetli Oslan", "Magister Ilmu Komputer", "yetli@email.com",
                "Jl. Teratai No. 2"));
        dosenArrayList.add(new Dosen("50451",
                "Budi Sutedjo", "Magister Manajemen Sistem Informasi", "budi@email.com",
                "Jl. Kamboja No. 10"));
        dosenArrayList.add(new Dosen("40333",
                "Umi Proboyekti", "Magister Ilmu Komputer", "umi@email.com",
                "Jl. Tulip No. 3"));

    }*/

}
