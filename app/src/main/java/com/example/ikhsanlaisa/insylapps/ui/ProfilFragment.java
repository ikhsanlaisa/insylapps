package com.example.ikhsanlaisa.insylapps.ui;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ikhsanlaisa.insylapps.Constant;
import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.UserResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;
import com.orhanobut.hawk.Hawk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {
    TextView names, uemail;
    ImageView photo;
    String imgDecodableString;

    public ProfilFragment() {
        // Required empty public constructor
//        userprofil();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_profil, container, false);
        names = view.findViewById(R.id.name);
        uemail = view.findViewById(R.id.uemail);
        photo = view.findViewById(R.id.fotoprofil);
//
        Api.getService().user().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()){
                    UserResponse userResponse = response.body();
                    names.setText(userResponse.getNama());
                    uemail.setText(userResponse.getEmail());
                    Glide.with(ProfilFragment.this).load(Constant.BASE_URL_PHOTO + "user/" + userResponse.getFoto()).into(photo);
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

        TextView uprofil = view.findViewById(R.id.uprofil);
        uprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), UpdateProfile.class));
                Toast.makeText(getActivity(), "Update Profil", Toast.LENGTH_LONG).show();
            }
        });

        TextView ulogout = view.findViewById(R.id.ulogout);
        ulogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hawk.deleteAll();
                startActivity(new Intent(getActivity(), loginActivity.class));
                Toast.makeText(getActivity(), "Logout", Toast.LENGTH_LONG).show();
            }
        });

        ImageView imglogout = view.findViewById(R.id.imglogout);
        imglogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hawk.deleteAll();
                startActivity(new Intent(getActivity(), loginActivity.class));
                getActivity().finish();
                Toast.makeText(getActivity(), "Logout", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == 1 && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                // Set the Image in ImageView after decoding the String
                photo.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(getActivity(), "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }

}
