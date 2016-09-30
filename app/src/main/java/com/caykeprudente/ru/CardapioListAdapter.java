package com.caykeprudente.ru;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cayke on 28/09/16.
 */

public class CardapioListAdapter extends ArrayAdapter<Ingredient> {

    public CardapioListAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public CardapioListAdapter(Context context, int resource, ArrayList<Ingredient> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.row_cardapio_layout, null);
        }

        Ingredient ingredient = getItem(position);

        TextView textViewName = (TextView) view.findViewById(R.id.tv_row_cardapio_name);
        textViewName.setText(ingredient.getName());

        TextView textViewCalories = (TextView) view.findViewById(R.id.tv_row_cardapio_calories);
        textViewCalories.setText(String.valueOf(ingredient.getCalories()));

        return view;
    }
}
