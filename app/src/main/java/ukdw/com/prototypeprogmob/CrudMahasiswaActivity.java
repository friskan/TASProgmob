package ukdw.com.prototypeprogmob;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ukdw.com.prototypeprogmob.Model.DefaultResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response; //menghasilkan data JSON
import ukdw.com.prototypeprogmob.Network.GetDataService;
import ukdw.com.prototypeprogmob.Network.RetrofitClientInstance;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;

public class CrudMahasiswaActivity extends AppCompatActivity {

    EditText editNama,editNim,editAlamat,editEmail,editFoto;
    Button btnSave, btnBrowse;
    ImageView imgFoto;
    private Boolean isUpdate = false;
    String idMhs ="", Img;
    String stringImg = "";
    GetDataService service;
    ProgressDialog progressDialog;
    Bitmap bitmap;
    static final int IMG_REQ = 777;
    byte[] imagByte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_mahasiswa);
        this.setTitle("Welcome Admin");

        editNama = (EditText)findViewById(R.id.editTextNama);
        editNim = (EditText)findViewById(R.id.editTextNim);
        editAlamat = (EditText)findViewById(R.id.editTextAlamat);
        editEmail = (EditText)findViewById(R.id.editTextEmail);
        //editFoto = (EditText)findViewById(R.id.editTextFoto);
        imgFoto = (ImageView)findViewById(R.id.imgCrudFotoDosen);
        btnBrowse = (Button)findViewById(R.id.btnBrowseFotomMhs);

        progressDialog = new ProgressDialog(this);

        checkUpdate();

        btnSave = (Button)findViewById(R.id.simpanButton);
        if(isUpdate){
            btnSave.setText("Update");
        }



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean isValid = true;

                //Validation

                if(editNama.getText().toString().matches("")){
                    editNama.setError("Silahkan mengisi Nama Mahasiswa");
                    isValid = false;
                }

                if(editNim.getText().toString().matches("")){
                    editNim.setError("Silahkan mengisi NIM");
                    isValid = false;
                }

                if(editAlamat.getText().toString().matches("")){
                    editAlamat.setError("Silahkan mengisi Alamat Mahasiswa");
                    isValid = false;
                }

                if(editEmail.getText().toString().matches("")){
                    editEmail.setError("Silahkan mengisi Email Mahasiswa");
                    isValid = false;
                }


                if(!isUpdate){
                    if(isValid){
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(CrudMahasiswaActivity.this);

                        builder.setMessage("Apakah anda yakin untuk menyimpan?")
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(CrudMahasiswaActivity.this, "Batal Simpan", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        requestInsertMahasiswa();
                                    }
                                });

                        android.app.AlertDialog dialog = builder.create(); dialog.show();
                    } else {
                        Toast.makeText(CrudMahasiswaActivity.this,"Silahkan Isi Data",Toast.LENGTH_LONG).show();
                    }
                }else if(isUpdate){
                    if (isValid) {
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(CrudMahasiswaActivity.this);

                        builder.setMessage("Apakah Anda yakin untuk menyimpan?")
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(CrudMahasiswaActivity.this, "Batal Simpan", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        requestUpdateMahasiswa();

                                    }
                                });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }else {
                        Toast.makeText(CrudMahasiswaActivity.this,"Silahkan Isi Data",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
    }

    private void requestInsertMahasiswa(){
        String gambar = imageToString();
        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        progressDialog =  ProgressDialog.show(this, null, "Loading...", true, false);

        Call<DefaultResult> call =  service.insert_mahasiswa_foto(editNama.getText().toString(),editNim.getText().toString(),
                editAlamat.getText().toString(),editEmail.getText().toString(),gambar,
                "72170157");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                progressDialog.dismiss();
                Toast.makeText(CrudMahasiswaActivity.this,"Berhasil Insert",Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(CrudMahasiswaActivity.this, RecyclerViewMahasiswaActivity.class);
                startActivity(refresh);
                finish();

            }
            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CrudMahasiswaActivity.this,"Error",Toast.LENGTH_SHORT);
            }
        });
    }
    private void requestUpdateMahasiswa(){
        String gambar = imageToString();
        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        progressDialog = ProgressDialog.show(CrudMahasiswaActivity.this, null, "Loading...", true, false);

        Call<DefaultResult> call = service.update_mhs(idMhs, editNama.getText().toString(), editNim.getText().toString(),
                editAlamat.getText().toString(), editEmail.getText().toString(), gambar,
                "72170157");
        call.enqueue(new Callback<DefaultResult>() {
            @Override
            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                progressDialog.dismiss();
                Toast.makeText(CrudMahasiswaActivity.this, "Berhasil Update", Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(CrudMahasiswaActivity.this, RecyclerViewMahasiswaActivity.class);
                startActivity(refresh);
                finish();

            }

            @Override
            public void onFailure(Call<DefaultResult> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CrudMahasiswaActivity.this, "Error", Toast.LENGTH_SHORT);
            }
        });
    }

    void checkUpdate(){
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            return;
        }
        isUpdate = extras.getBoolean("is_update");
        idMhs = extras.getString("id_mhs");
        editNama.setText(extras.getString("nama_mhs"));
        editNim.setText(extras.getString("nim"));
        editAlamat.setText(extras.getString("alamat_mhs"));
        editEmail.setText(extras.getString("email_mhs"));

        imagByte = Base64.decode(extras.getString("foto_mhs"), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imagByte, 0, imagByte.length);
        imgFoto.setImageBitmap(decodedImage);
    }

    private void selectImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMG_REQ && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                imgFoto.setImageBitmap(bitmap);
                imgFoto.setVisibility(View.VISIBLE);
                btnBrowse.setEnabled(true);
                btnSave.setEnabled(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        imagByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imagByte, Base64.DEFAULT);
    }


        /*Button simpanButton = (Button)findViewById(R.id.simpanButton);

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CrudMahasiswaActivity.this);
                builder.setMessage("Anda ingin simpan data?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(CrudMahasiswaActivity.this, "Tidak jadi simpan",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(CrudMahasiswaActivity.this,HomeAdminActivity.class);
                                startActivity(i);
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });*/

}
