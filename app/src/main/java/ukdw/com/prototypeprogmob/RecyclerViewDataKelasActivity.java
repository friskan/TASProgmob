package ukdw.com.prototypeprogmob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Adapter.DataKelasAdapter;
import ukdw.com.prototypeprogmob.Model.DataKelas;

public class RecyclerViewDataKelasActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataKelasAdapter dataKelasAdapter;
    private ArrayList<DataKelas> dataKelasArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_kelas);

        /*ImageButton imgButtonCrudDosen = (ImageButton) findViewById(R.id.imgButtonCrudDosen);
        imgButtonCrudDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecyclerViewDosenActivity.this,CrudDosenActivity.class);
                startActivity(i);
            }
        });*/

        addData();

        recyclerView = findViewById(R.id.recyclerViewKelas);
        dataKelasAdapter = new DataKelasAdapter(dataKelasArrayList);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(RecyclerViewDataKelasActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataKelasAdapter);
    }

    public void klikDataKelas(View view)
    {
        Intent i = new Intent(RecyclerViewDataKelasActivity.this,HomeDosenActivity.class);
        startActivity(i);
    }

    private void addData(){
        dataKelasArrayList = new ArrayList<>();
        dataKelasArrayList.add(new DataKelas("SI133",
                "Pemrograman", "Senin", "Sesi II",
                "Katon Wijana", "40 Mahasiswa"));
        dataKelasArrayList.add(new DataKelas("SE313",
                "E-Commerce", "Selasa", "Sesi IV",
                "Budi Sutedjo", "65 Mahasiswa"));
        dataKelasArrayList.add(new DataKelas("SI253",
                "Analisis Data Bisnis", "Kamis", "Sesi II",
                "Jong Jek Siang", "37 Mahasiswa"));
        dataKelasArrayList.add(new DataKelas("SI323",
                "Manajemen Proyek", "Rabu", "Sesi III",
                "Yetli Oslan", "75 Mahasiswa"));

    }

}
