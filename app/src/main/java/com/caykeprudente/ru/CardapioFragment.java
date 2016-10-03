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

    private Realm myRealm;

    final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static final int Salada = 1;
    public static final int Molho = 2;
    public static final int Principal = 3;
    public static final int Guarnicao = 4;
    public static final int Vegetariano = 5;
    public static final int Complementos = 6;
    public static final int Sobremesa = 7;
    public static final int Suco = 8;

    public static final int Cafe = 1;
    public static final int Almoco = 2;
    public static final int Jantar = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.cardapio_layout, container, false);
        myRealm = Realm.getDefaultInstance();

        criarDbCardapio(myRealm);
        ArrayList itens = new ArrayList();
        try {
            itens = basicQuery(myRealm,new Date(format.parse("03/10/2016").getTime()),Cafe);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        listView = (ListView) view.findViewById(R.id.listViewCardapio);

        // Create ArrayAdapter using the planet list.
        listAdapter = new CardapioListAdapter(this.getContext(), R.layout.row_cardapio_layout, itens);

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

    private void updateTextView ()
    {
        tvTitle.setText(listDates.get(indexDate));
    }

    private void criarDbCardapio(final Realm myRealm){

        RealmList arrayList = new RealmList();
        try {
            Date data = new Date(format.parse("03/10/2016").getTime());
            //cafe
            arrayList.add(new ItemCardapio("Alface crespa e pepino", Salada,10,data, Cafe));
            arrayList.add(new ItemCardapio("Molho vinagrete", Molho,20,data, Cafe));
            arrayList.add(new ItemCardapio("Carne de sol acebolada", Principal,30,data, Cafe));
            arrayList.add(new ItemCardapio("Mandioca cozida", Guarnicao,40,data, Cafe));
            arrayList.add(new ItemCardapio("Lentilha com legumes", Vegetariano,50,data, Cafe));
            arrayList.add(new ItemCardapio("Arroz branco, arroz integral e Feijão", Complementos,60,data, Cafe));
            arrayList.add(new ItemCardapio("Mamão", Sobremesa,70,data, Cafe));
            arrayList.add(new ItemCardapio("Limão", Suco,80,data, Cafe));
            //almoco
            arrayList.add(new ItemCardapio("Mix de folhas e rabanete", Salada,10,data, Almoco));
            arrayList.add(new ItemCardapio("Molho de manjericão", Molho,20,data, Almoco));
            arrayList.add(new ItemCardapio("Frango à parisiense (peito)", Principal,30,data, Almoco));
            arrayList.add(new ItemCardapio("Beterraba cozida", Guarnicao,40,data, Almoco));
            arrayList.add(new ItemCardapio("Picadinho de soja à carioca (ptn de soja grossa escura) ", Vegetariano,50,data, Almoco));
            arrayList.add(new ItemCardapio("Arroz c/ cenoura, arroz integral e Feijão", Complementos,60,data, Almoco));
            arrayList.add(new ItemCardapio("Laranja", Sobremesa,70,data, Almoco));
            arrayList.add(new ItemCardapio("Goiaba", Suco,80,data, Almoco));
            //janta
            arrayList.add(new ItemCardapio("Mix de folhas e rabanete", Salada,10,data, Jantar));
            arrayList.add(new ItemCardapio("Molho de manjericão", Molho,20,data, Jantar));
            arrayList.add(new ItemCardapio("Frango à parisiense (peito)", Principal,30,data, Jantar));
            arrayList.add(new ItemCardapio("Beterraba cozida", Guarnicao,40,data, Jantar));
            arrayList.add(new ItemCardapio("Picadinho de soja à carioca (ptn de soja grossa escura) ", Vegetariano,50,data, Jantar));
            arrayList.add(new ItemCardapio("Arroz c/ cenoura, arroz integral e Feijão", Complementos,60,data, Jantar));
            arrayList.add(new ItemCardapio("Laranja", Sobremesa,70,data, Jantar));
            arrayList.add(new ItemCardapio("Goiaba", Suco,80,data, Jantar));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        inserirItemCardapio(myRealm,arrayList);
    }

    private void inserirItemCardapio(final Realm myRealm, final RealmList<ItemCardapio> itens){
        myRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(itens);
            }
        });
    }

    private ArrayList basicQuery(Realm realm, Date data, int refeicao) {
        RealmResults<ItemCardapio> results = realm.where(ItemCardapio.class).equalTo("data",data ).equalTo("refeicao",refeicao).findAll();
        ArrayList itens = new ArrayList();
        for(ItemCardapio item : results){
            itens.add(item);
        }
        return itens;
    }
}
