package com.example.ikhsanlaisa.insylapps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.ikhsanlaisa.insylapps.R;
import com.orhanobut.hawk.Hawk;

import java.util.HashMap;

import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    private SliderLayout sliderLayout;
    GridLayout GL;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sliderLayout = findViewById(R.id.slider);
        GL = findViewById(R.id.gridlayout);

        HashMap<String, Integer> fileMaps = new HashMap<String, Integer>();
        fileMaps.put("hehhee", R.drawable.juara);
        fileMaps.put("hbehfbe", R.drawable.klasemen);
        fileMaps.put("ekjed", R.drawable.register);
        fileMaps.put("hejehjkehhee", R.drawable.score);

        for (String name : fileMaps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView.description(name).image(fileMaps.get(name)).setScaleType(BaseSliderView.ScaleType.Fit);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);

        setToggleEvent(GL);
    }

    private void setToggleEvent(GridLayout GL) {
        for (int i = 0; i < GL.getChildCount(); i++) {
            final CardView cardView = (CardView) GL.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (finalI) {
                        case 0:
                            Intent intent = new Intent(HomeActivity.this, ScoreActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Toast.makeText(HomeActivity.this, "Clicked at index " + finalI, Toast.LENGTH_LONG).show();
                            break;
                        case 2:
                            Intent intent2 = new Intent(HomeActivity.this, KontakActivity.class);
                            startActivity(intent2);
                            Toast.makeText(HomeActivity.this, "Clicked at index " + finalI, Toast.LENGTH_LONG).show();
                            break;
                        case 3:
                            Toast.makeText(HomeActivity.this, "Clicked at index " + finalI, Toast.LENGTH_LONG).show();
                            break;
                    }
                }
            });
        }
    }


    @OnClick(R.id.btnlogout)
    public void logout(){
        Hawk.deleteAll();
        startActivity(new Intent(HomeActivity.this, loginActivity.class));
        finish();
    }

    @Override
    public int getContent() {
        return R.layout.activity_home;
    }
}
