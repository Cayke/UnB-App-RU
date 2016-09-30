package com.caykeprudente.ru;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cayke on 28/09/16.
 */

public class ConfigFragment extends Fragment {
    FavoritosListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.config_layout, container, false);
        super.onCreate(savedInstanceState);

        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);
        prepareListData();

        final Switch sButton = (Switch) view.findViewById(R.id.switch_btn);

        sButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            public void onCheckedChanged(CompoundButton cb, boolean on){
                if(on)
                {
                    openDialog();
                }
            }
        });

        listAdapter = new FavoritosListAdapter(this.getActivity(), listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

        return view;

    }

    public void openDialog() {
        DialogFragment newFragment = new NotificacaoDialog();
        newFragment.show(getActivity().getSupportFragmentManager(), "missiles");
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Favoritos");

        List<String> top250 = new ArrayList<String>();
        top250.add("Feijoada");
        top250.add("Lasanha");
        top250.add("Abóbora cosida");
        top250.add("Achocolatado");
        top250.add("Banana");
        top250.add("Banana ao forno");
        top250.add("Bife de panela");
        top250.add("Cenoura");
        top250.add("Creme de ervilha");
        top250.add("Cubos bovino");
        top250.add("Ensopado de frango");
        top250.add("Fricasse");
        top250.add("Goiaba");
        top250.add("Laranja");
        top250.add("Mamão");
        top250.add("Melão");
        top250.add("Melancia");

        listDataChild.put(listDataHeader.get(0), top250);
    }
}
