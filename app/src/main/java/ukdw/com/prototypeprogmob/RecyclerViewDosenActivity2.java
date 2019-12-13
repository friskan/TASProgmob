package ukdw.com.prototypeprogmob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Adapter.DosenAdapter;
import ukdw.com.prototypeprogmob.Model.Dosen;

public class RecyclerViewDosenActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen> dosenArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        /*ImageButton imgButtonCrudDosen = (ImageButton) findViewById(R.id.imgButtonCrudDosen);
        imgButtonCrudDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecyclerViewDosenActivity.this,CrudDosenActivity.class);
                startActivity(i);
            }
        });*/

        //addData();

        recyclerView = findViewById(R.id.recyclerView);
        dosenAdapter = new DosenAdapter(dosenArrayList);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(RecyclerViewDosenActivity2.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dosenAdapter);
    }

    public void klikCrudDosen(View view)
    {
        Intent i = new Intent(RecyclerViewDosenActivity2.this,HomeDosenActivity.class);
        startActivity(i);
    }
    /*private void addData(){
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
