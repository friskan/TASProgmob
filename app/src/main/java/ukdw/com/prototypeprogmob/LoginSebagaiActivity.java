package ukdw.com.prototypeprogmob;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginSebagaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sebagai);

        Button btnLoginAdmin = (Button) findViewById(R.id.btnAdmin);
        btnLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginSebagaiActivity.this,HomeAdminActivity.class);
                startActivity(i);
            }
        });

        Button btnLoginDosen = (Button) findViewById(R.id.btnDosen);
        btnLoginDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginSebagaiActivity.this,HomeDosenActivity.class);
                startActivity(i);
            }
        });
    }
}
