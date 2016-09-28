package com.caykeprudente.ru;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cayke on 28/09/16.
 */

public class CardapioFragment extends Fragment {
    ListView listView;
    ImageButton ibLeft, ibRight;
    TextView tvTitle;

    ArrayList<String> listDates;
    int indexDate = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.cardapio_layout, container, false);

        listView = (ListView) view.findViewById(R.id.listViewCardapio);
        tvTitle = (TextView) view.findViewById(R.id.textViewCardapioDate);

        ibLeft = (ImageButton) view.findViewById(R.id.imageButtonCardapioLeft);
        ibLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indexDate > 0)
                {
                    indexDate--;
                    updateTextView();
                }
            }
        });

        ibRight = (ImageButton) view.findViewById(R.id.imageButtonCardapioRight);
        ibRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indexDate < listDates.size()-1)
                {
                    indexDate++;
                    updateTextView();
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
        listDates.add("01/10 Sábado");
    }

    private void updateTextView ()
    {
        tvTitle.setText(listDates.get(indexDate));
    }

}
