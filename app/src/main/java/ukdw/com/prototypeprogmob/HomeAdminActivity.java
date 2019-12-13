package ukdw.com.prototypeprogmob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeAdminActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulogout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout){
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(HomeAdminActivity.this);

            builder.setMessage("Apakah anda yakin akan keluar?")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(HomeAdminActivity.this, "Batal Keluar", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences prefs = HomeAdminActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);

                            String statusLogin = prefs.getString("isLogin",null);
                            SharedPreferences.Editor edit = prefs.edit();
                            edit.putString("isLogin" , null);
                            edit.commit();

                            Intent intent = new Intent(HomeAdminActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    });

            AlertDialog dialog = builder.create(); dialog.show();
        }
        return  true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        this.setTitle("Welcome Admin");

        ImageButton daftarDosenImgButton = (ImageButton)findViewById(R.id.imgButtonDaftarDosen);
        daftarDosenImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdminActivity.this,RecyclerViewDosenActivity.class);
                startActivity(i);
            }
        });

        ImageButton dataDiriImgButton = (ImageButton)findViewById(R.id.imgButtonDataDiri);
        dataDiriImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdminActivity.this,CrudDosenActivity.class);
                startActivity(i);
            }
        });

        /*Button logoutButton = (Button)findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeAdminActivity.this);
                builder.setMessage("Apakah anda yakin akan keluar?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(HomeAdminActivity.this, "Tidak jadi keluar",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(HomeAdminActivity.this,LoginActivity.class);
                                startActivity(i);
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });*/

        ImageButton daftarMatkulImgButton = (ImageButton)findViewById(R.id.imgBtnDaftarMatkul);
        daftarMatkulImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdminActivity.this,RecyclerViewMatkulActivity.class);
                startActivity(i);
            }
        });

        ImageButton kelolaKrsImgButton = (ImageButton)findViewById(R.id.imgBtnKelolaKrs);
        kelolaKrsImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdminActivity.this,RecyclerViewKrsActivity.class);
                startActivity(i);
            }
        });

        ImageButton daftarMhsImgButton = (ImageButton)findViewById(R.id.imgButtonDaftarMhs);
        daftarMhsImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdminActivity.this,RecyclerViewMahasiswaActivity.class);
                startActivity(i);
            }
        });
    }
}
