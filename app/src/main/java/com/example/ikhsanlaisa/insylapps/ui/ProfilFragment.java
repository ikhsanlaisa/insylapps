package com.example.ikhsanlaisa.insylapps.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.Response.UserResponse;
import com.example.ikhsanlaisa.insylapps.service.Api;
import com.orhanobut.hawk.Hawk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    public ProfilFragment() {
        // Required empty public constructor
//        userprofil();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_profil, container, false);
        final TextView names = view.findViewById(R.id.name);
        final TextView uemail = view.findViewById(R.id.uemail);
        Call<List<UserResponse>> getUserResponse = Api.getService().user();
        getUserResponse.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                        if (response.isSuccessful()){
                            List<UserResponse> userResponses = response.body();
                            JSONArray jsonArray = new JSONArray(userResponses);
                            Log.d("ini pesannya", "datanya : "+ userResponses.size());
                            for (int i=0; i<jsonArray.length(); i++){

                            }

                        }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {

            }
        });


        TextView uprofil = view.findViewById(R.id.uprofil);
        uprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), UpdateProfileActivity.class));
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
                Toast.makeText(getActivity(), "Logout", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
