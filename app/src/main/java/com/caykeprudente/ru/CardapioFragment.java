package com.caykeprudente.ru;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cayke on 28/09/16.
 */

public class CardapioFragment extends Fragment {
    ListView listView;
    CardapioListAdapter listAdapter;

    ImageButton ibLeft, ibRight;
    TextView tvTitle;
    TabHost tabHost;

    ArrayList<String> listDates;
    int indexDate = 0;
    int indexMeal = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.cardapio_layout, container, false);

        listView = (ListView) view.findViewById(R.id.listViewCardapio);

        // Create ArrayAdapter using the planet list.
        listAdapter = new CardapioListAdapter(this.getContext(), R.layout.row_cardapio_layout, getArrayWithIngredients());

        listView.setAdapter(listAdapter);

        tvTitle = (TextView) view.findViewById(R.id.textViewCardapioDate);

        ibLeft = (ImageButton) view.findViewById(R.id.imageButtonCardapioLeft);
        ibLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indexDate > 0) {
                    indexDate--;
                    updateTextView();
                }
            }
        });

        ibRight = (ImageButton) view.findViewById(R.id.imageButtonCardapioRight);
        ibRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indexDate < listDates.size() - 1) {
                    indexDate++;
                    updateTextView();
                }
            }
        });

        tabHost = (TabHost) view.findViewById(R.id.tabHost);
        tabHost.setup();

        //Tab 1
        TabHost.TabSpec spec = tabHost.newTabSpec(getResources().getString(R.string.tab_cafe));
        spec.setContent(R.id.tab1);
        spec.setIndicator(getResources().getString(R.string.tab_cafe));
        tabHost.addTab(spec);

        //Tab 2
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab_almoco));
        spec.setContent(R.id.tab2);
        spec.setIndicator(getResources().getString(R.string.tab_almoco));
        tabHost.addTab(spec);

        //Tab 3
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab_janta));
        spec.setContent(R.id.tab3);
        spec.setIndicator(getResources().getString(R.string.tab_janta));
        tabHost.addTab(spec);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s.equals(getResources().getString(R.string.tab_cafe)))
                {
                    indexMeal = 0;
                }
                else if(s.equals(getResources().getString(R.string.tab_almoco)))
                {
                    indexMeal = 1;
                }
                else if (s.equals(getResources().getString(R.string.tab_janta)))
                {
                    indexMeal = 2;
                }
            }
        });

        populateDateArray();

        return view;
    }

    private void populateDateArray ()
    {
        listDates = new ArrayList<>();
        listDates.add("26/09 Segunda-feira");
        listDates.add("27/09 Terça-feira");
        listDates.add("28/09 Quarta-feira");
        listDates.add("29/09 Quinta-feira");
        listDates.add("30/09 Sexta-feira");
    }

    private ArrayList<Ingredient> getArrayWithIngredients ()
    {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Ingredient("Caçarola marinada (paleta)", Ingredient.Type.Carne, 180));
        arrayList.add(new Ingredient("Cuscuz vegetariano", Ingredient.Type.Vegano, 120));
        arrayList.add(new Ingredient("Ratattouile", Ingredient.Type.Sobremesa, 45));
        arrayList.add(new Ingredient("Gelatina", Ingredient.Type.Sobremesa, 30));
        arrayList.add(new Ingredient("Arroz branco, arroz integral, feijao preto e aquela farinha sem sabor de lei", Ingredient.Type.Carne, 79));
        arrayList.add(new Ingredient("Acelga e nabo com tomate", Ingredient.Type.Carne, 10));
        arrayList.add(new Ingredient("Molho de salsa", Ingredient.Type.Carne, 30));
        arrayList.add(new Ingredient("Caçarola marinada (paleta)", Ingredient.Type.Carne, 180));
        arrayList.add(new Ingredient("Cuscuz vegetariano", Ingredient.Type.Vegano, 120));
        arrayList.add(new Ingredient("Ratattouile", Ingredient.Type.Sobremesa, 45));
        arrayList.add(new Ingredient("Gelatina", Ingredient.Type.Sobremesa, 30));
        return arrayList;
    }

    private void updateTextView ()
    {
        tvTitle.setText(listDates.get(indexDate));
    }

}
