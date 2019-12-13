package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();

        SharedPreferences prefs = LoginActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
        String statusLogin = prefs.getString("isLogin", null);

        Button btnLogin = (Button) findViewById(R.id.loginBtn);
        btnLogin.setOnClickListener(myBtnLoginClick);

        if (statusLogin != null) {
            btnLogin.setText("Logout");
        } else {
            btnLogin.setText("Login");
        }

        /*Button btnLogin = (Button) findViewById(R.id.loginBtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,LoginSebagaiActivity.class);
                startActivity(i);
            }
        });*/
    }

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = LoginActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
            String statusLogin = prefs.getString("isLogin", null);
            SharedPreferences.Editor edit = prefs.edit();

            TextView emailText = findViewById(R.id.email);
            //Button btnLogin = (Button)findViewById(R.id.loginBtn);
            if (emailText.getText().toString().contains("si")) {
                edit.putString("isLogin", "Dosen");
                edit.commit();
                Intent i = new Intent(LoginActivity.this, HomeDosenActivity.class);
                startActivity(i);
                //btnLogin.setText("Login");
            } else if (emailText.getText().toString().contains("staff")) {
                edit.putString("isLogin", "Admin");
                edit.commit();
                Intent i = new Intent(LoginActivity.this, HomeAdminActivity.class);
                startActivity(i);
            }
        }
    };
}
