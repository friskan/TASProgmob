package ukdw.com.prototypeprogmob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Adapter.KrsAdapter;
import ukdw.com.prototypeprogmob.Model.Krs;

public class RecyclerViewKrsActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private KrsAdapter krsAdapter;
    private ArrayList<Krs> krsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_krs);

        addData();

        recyclerView = findViewById(R.id.recyclerViewKrs);
        krsAdapter = new KrsAdapter(krsArrayList);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(RecyclerViewKrsActivity2.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(krsAdapter);
    }
    public void klikCrudKrs(View view)
    {
        Intent i = new Intent(RecyclerViewKrsActivity2.this,HomeDosenActivity.class);
        startActivity(i);
    }
    private void addData(){
        krsArrayList = new ArrayList<>();
        krsArrayList.add(new Krs("SI133",
                "Pemrograman", "Katon Wijana"));
        krsArrayList.add(new Krs("SE313",
                "E-Commerce", "Budi Sutedjo"));
        krsArrayList.add(new Krs("SI323",
                "Manajemen Proyek", "Yetli Oslan"));
        krsArrayList.add(new Krs("SI343",
                "Keamanan Teknologi Informasi", "Umi Proboyekti"));
        krsArrayList.add(new Krs("SI253",
                "Analisis Data Bisnis", "Jong Jek Siang"));

    }

}
