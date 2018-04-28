package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.KelasResponse;
import com.example.ikhsanlaisa.insylapps.Response.UserResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class UpdateProfile extends BaseActivity implements AdapterView.OnItemClickListener {
    private final int SELECT_PICTURE = 1;
    EditText nama, email, tgl_lahir, no_hp, alamat, kelas;
    Spinner spkelas;
    Button save;
    SharedPreferences text;
    ImageView imgprof;
    Button choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nama = findViewById(R.id.uname);
        kelas = findViewById(R.id.kelas);
        email = findViewById(R.id.email);
        tgl_lahir = findViewById(R.id.tgl_lahir);
        no_hp = findViewById(R.id.no_hp);
        alamat = findViewById(R.id.alamat);
        save = findViewById(R.id.save);
        choose = findViewById(R.id.choose);
        imgprof = findViewById(R.id.gambardaripost);
        spkelas = findViewById(R.id.spkelas);

//        String path = text.child
//        SharedPreferences a = text.
        Api.getService().user().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()){
                    UserResponse userResponse = response.body();
                    nama.setText(userResponse.getNama());
                    email.setText(userResponse.getEmail());
                    tgl_lahir.setText(userResponse.getTgl_lahir());
                    no_hp.setText(userResponse.getNo_hp());
                    alamat.setText(userResponse.getAlamat());
                    kelas.setText(String.valueOf(userResponse.getKelas_id()));
                    Glide.with(UpdateProfile.this).load(Constant.BASE_URL_PHOTO + "user/" + userResponse.getFoto()).into(imgprof);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

        inispinnerkelas();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api.getService().updateuser(nama.getText().toString(), email.getText().toString(), tgl_lahir.getText().toString(), no_hp.getText().toString(), alamat.getText().toString(), spkelas.getSelectedItemPosition()+1).enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(UpdateProfile.this,"berhasil", Toast.LENGTH_LONG).show();
                            Log.d("datajskndksd", String.valueOf(spkelas.getSelectedItemPosition()));
//                            Glide.with(ProfilFragment.this).load(Constant.BASE_URL_PHOTO + "news/" + userResponse.getFoto()).into(photo);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {

                    }
                });
            }
        });

    }

    private void inispinnerkelas() {
        Api.getService().kelas().enqueue(new Callback<List<KelasResponse>>() {
            @Override
            public void onResponse(Call<List<KelasResponse>> call, Response<List<KelasResponse>> response) {
                if (response.isSuccessful()){
                    List<KelasResponse> kelasResponses = response.body();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < kelasResponses.size(); i++){
                        listSpinner.add(kelasResponses.get(i).getNama());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(UpdateProfile.this,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spkelas.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<KelasResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public int getContent() {
        return R.layout.activity_update_profile;
    }

    public void choose(View view) {
        Intent pickImage = new Intent(Intent.ACTION_PICK);
        pickImage.setType("image/*");

        startActivityForResult(pickImage, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK){
            if(requestCode==SELECT_PICTURE){

                //Mendapatkan data dari intent
                Uri imageUri = data.getData();
                try {
                    //Merubah data menjadi inputstream yang diolah menjadi bitmap dan ditempatkan pada imageview
                    InputStream stream = getContentResolver().openInputStream(imageUri);
                    Bitmap gambar = BitmapFactory.decodeStream(stream);
                    imgprof.setImageBitmap(gambar);
                } catch (FileNotFoundException e) {
                    Log.w("FileNotFoundException", e.getMessage());
                    Toast.makeText(this, "Unable to load image", Toast.LENGTH_SHORT).show();
                }
            }

            //Ketika user tidak memilih foto
        }else{
            Toast.makeText(this, "Picture not selected", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedName = parent.getItemAtPosition(position).toString();

        Toast.makeText(UpdateProfile.this, "Kamu memilih kelas " + selectedName, Toast.LENGTH_SHORT).show();
    }
}
