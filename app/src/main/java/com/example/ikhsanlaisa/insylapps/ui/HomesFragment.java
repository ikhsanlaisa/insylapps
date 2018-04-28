package com.example.ikhsanlaisa.insylapps.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.ikhsanlaisa.insylapps.R;
import com.orhanobut.hawk.Hawk;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomesFragment extends Fragment {
    private SliderLayout sliderLayout;
    GridLayout GL;

//    @BindView(R.id.btnlogout)
//    Button btnlogin;

    public HomesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_homes, container, false);

        sliderLayout = rootView.findViewById(R.id.slider);
        GL = rootView.findViewById(R.id.gridlayout);
//        btnNV = rootView.findViewById(R.id.NavBot);
        HashMap<String, Integer> fileMaps = new HashMap<String, Integer>();
        fileMaps.put("hehhee", R.drawable.juara);
        fileMaps.put("hbehfbe", R.drawable.klasemen);
        fileMaps.put("ekjed", R.drawable.register);
        fileMaps.put("hejehjkehhee", R.drawable.score);

        for (String name : fileMaps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView.description(name).image(fileMaps.get(name)).setScaleType(BaseSliderView.ScaleType.Fit);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);

//        logout();
        setToggleEvent(GL);
        return rootView;
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
                            Intent intent = new Intent(getActivity(), ScoreActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(getActivity(), KlasemenActivity.class);
                            startActivity(intent1);
                            Toast.makeText(getActivity(), "Clicked at index " + finalI, Toast.LENGTH_LONG).show();
                            break;
                        case 2:
                            Intent intent2 = new Intent(getActivity(), KontakActivity.class);
                            startActivity(intent2);
                            Toast.makeText(getActivity(), "Clicked at index " + finalI, Toast.LENGTH_LONG).show();
                            break;
                        case 3:
                            Intent intent3 = new Intent(getActivity(), RegisterLombaActivity.class);
                            startActivity(intent3);
                            Toast.makeText(getActivity(), "Clicked at index " + finalI, Toast.LENGTH_LONG).show();
                            break;
                    }
                }
            });
        }
    }

//    @OnClick(R.id.btnlogout)
//    void logout(){
//        Toast.makeText(getActivity(), "Logged out", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(getActivity(), loginActivity.class));
//        Hawk.deleteAll();
//    }
}
