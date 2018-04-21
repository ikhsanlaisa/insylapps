package com.example.ikhsanlaisa.insylapps.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ikhsanlaisa.insylapps.R;
import com.example.ikhsanlaisa.insylapps.ui.BaseActivity;

public class MenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationView btnNV = findViewById(R.id.NavBot);
        btnNV.setOnNavigationItemSelectedListener(mSelected);

        HomesFragment fragment = new HomesFragment();
        FragmentTransaction fti = getSupportFragmentManager().beginTransaction();
        fti.replace(R.id.content, fragment, "FragmentName");
        fti.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mSelected
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.home:
                    HomesFragment fragment = new HomesFragment();
                    FragmentTransaction fti = getSupportFragmentManager().beginTransaction();
                    fti.replace(R.id.content, fragment, "FragmentName");
                    fti.commit();
                    return true;
                case R.id.news:
                    NewsFragment fragment1 = new NewsFragment();
                    FragmentTransaction fti1 = getSupportFragmentManager().beginTransaction();
                    fti1.replace(R.id.content, fragment1, "FragmentName");
                    fti1.commit();
                    return true;
                case R.id.alert:
                    AlertFragment fragment2 = new AlertFragment();
                    FragmentTransaction fti2 = getSupportFragmentManager().beginTransaction();
                    fti2.replace(R.id.content, fragment2, "FragmentName");
                    fti2.commit();
                    return true;
                case R.id.profil:
                    ProfilFragment fragment3 = new ProfilFragment();
                    FragmentTransaction fti3 = getSupportFragmentManager().beginTransaction();
                    fti3.replace(R.id.content, fragment3, "FragmentName");
                    fti3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public int getContent() {
        return R.layout.activity_menu;
    }
}
