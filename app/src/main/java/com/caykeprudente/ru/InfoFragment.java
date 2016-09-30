package com.caykeprudente.ru;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.util.Log;
import android.widget.ViewFlipper;

public class InfoFragment extends Fragment{

    protected ImageButton btn_left;
    protected ImageButton btn_right;
    protected TextView text_nav_info;
    protected View.OnClickListener single_click_listener;
    protected ViewFlipper vf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.info_layout, container, false);


        btn_left = (ImageButton) view.findViewById(R.id.btn_left);
        btn_right = (ImageButton) view.findViewById(R.id.btn_right);
        text_nav_info = (TextView) view.findViewById(R.id.nav_info);

        vf = (ViewFlipper) view.findViewById(R.id.vf);


        single_click_listener = new View.OnClickListener() {
            public int num_screen = 0;
            public int qtd_screens = 4;

            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.btn_left:
                        num_screen--;
                        break;

                    case R.id.btn_right:
                        num_screen++;
                        break;
                }

                int _mod = num_screen%qtd_screens;
                if (_mod<0)
                    _mod = _mod*-1;
                vf.setDisplayedChild(_mod);

                if (_mod == 0) {
                    // mostrar tela 1 : O RU
                    text_nav_info.setText("O RU");
                } else if (_mod == 1) {
                    // mostrar tela 2 : CONTATOS
                    text_nav_info.setText("CONTATOS");
                } else if (_mod == 2) {
                    // mostrar tela 3 : POLÍTICAS DE USO
                    text_nav_info.setText("POLÍTICAS DE USO");
                } else if (_mod == 3) {
                    // mostrar tela 4 : FORNECEDORES
                    text_nav_info.setText("FORNECEDORES");
                }
            }
        };

        btn_left.setOnClickListener(single_click_listener);
        btn_right.setOnClickListener(single_click_listener);


        return view;
    }

}
