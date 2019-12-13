package ukdw.com.prototypeprogmob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Adapter.MatkulAdapter;
import ukdw.com.prototypeprogmob.Model.Matkul;

public class RecyclerViewMatkulActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MatkulAdapter matkulAdapter;
    private ArrayList<Matkul> matkulArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_matkul);

        addData();

        recyclerView = findViewById(R.id.recyclerViewMatkul);
        matkulAdapter = new MatkulAdapter(matkulArrayList);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(RecyclerViewMatkulActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(matkulAdapter);
    }

    public void klikCrudMatkuliah(View view)
    {
        Intent i = new Intent(RecyclerViewMatkulActivity.this,CrudMatkulActivity.class);
        startActivity(i);
    }
    private void addData(){
        matkulArrayList = new ArrayList<>();
        matkulArrayList.add(new Matkul("SI133",
                "Pemrograman", "Senin", "Sesi II (dua)",
                "3 sks"));
        matkulArrayList.add(new Matkul("SE313",
                "E-Commerce", "Selasa", "Sesi IV (empat)",
                "3 sks"));
        matkulArrayList.add(new Matkul("SI323",
                "Manajemen Proyek", "Rabu", "III (tiga)",
                "3 sks"));
        matkulArrayList.add(new Matkul("SI343",
                "Keamanan Teknologi Informasi", "Kamis", "Sesi I (satu)",
                "3 sks"));
        matkulArrayList.add(new Matkul("SI253",
                "Analisis Data Bisnis", "Kamis", "Sesi II (dua)",
                "3 sks"));

    }

}
