package com.caykeprudente.ru;

import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

import static android.R.attr.data;

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
        updateCardapioInfo();

        tvTitle = (TextView) view.findViewById(R.id.textViewCardapioDate);

        ibLeft = (ImageButton) view.findViewById(R.id.imageButtonCardapioLeft);
        ibLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indexDate > 0) {
                    indexDate--;
                    updateTextView();
                    updateCardapioInfo();
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
                    updateCardapioInfo();
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
                updateCardapioInfo();
            }
        });

        populateDateArray();

        return view;
    }

    private void populateDateArray ()
    {
        listDates = new ArrayList<>();
        listDates.add("03/10 Segunda-feira");
        listDates.add("04/10 Terça-feira");
        listDates.add("05/10 Quarta-feira");
        listDates.add("06/10 Quinta-feira");
        listDates.add("07/10 Sexta-feira");
    }

    private void updateCardapioInfo()
    {
        ArrayList<ItemCardapio> itens = Database.basicQuery(Realm.getDefaultInstance(),getSelectedDate(),getSelectedMeal());

        // Create ArrayAdapter using the planet list.
        listAdapter = new CardapioListAdapter(this.getContext(), R.layout.row_cardapio_layout, itens);

        listView.setAdapter(listAdapter);
    }

    private void updateTextView ()
    {
        tvTitle.setText(listDates.get(indexDate));
    }

    private Date getSelectedDate()
    {
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try{
            if (indexDate == 0)
                return new Date(format.parse("03/10/2016").getTime());
            else if (indexDate == 1)
                return new Date(format.parse("04/10/2016").getTime());
            else if (indexDate == 2)
                return new Date(format.parse("05/10/2016").getTime());
            else if (indexDate == 3)
                return new Date(format.parse("06/10/2016").getTime());
            else if (indexDate == 4)
                return new Date(format.parse("07/10/2016").getTime());
            else
                return null;
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    private int getSelectedMeal()
    {
        if (indexMeal == 0)
            return Database.Cafe;
        else if (indexMeal == 1)
            return Database.Almoco;
        else
            return Database.Jantar;
    }
}
