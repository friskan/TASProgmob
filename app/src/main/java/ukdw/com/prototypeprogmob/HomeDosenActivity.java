package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeDosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dosen);
        this.setTitle("Welcome Dosen");

        ImageButton dataDiriDosenImgButton = (ImageButton)findViewById(R.id.imgButtonDataDiriDosen);
        dataDiriDosenImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeDosenActivity.this,RecyclerViewDosenActivity2.class);
                startActivity(i);
            }
        });

        ImageButton daftarKrsImgButton = (ImageButton)findViewById(R.id.imgButtonDaftarKrs);
        daftarKrsImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeDosenActivity.this,RecyclerViewKrsActivity2.class);
                startActivity(i);
            }
        });

        ImageButton lihatKelasImgButton = (ImageButton)findViewById(R.id.imgButtonLihatKelas);
        lihatKelasImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeDosenActivity.this,RecyclerViewDataKelasActivity.class);
                startActivity(i);
            }
        });
    }
}
