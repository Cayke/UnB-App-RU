package com.caykeprudente.ru;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by cayke on 03/10/16.
 */

public class Database {
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

    public static void criarDbCardapio(){
        RealmList<ItemCardapio> arrayList = new RealmList();
        try {
            final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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

        inserirItemCardapio(Realm.getDefaultInstance(),arrayList);
    }

    private static void inserirItemCardapio(final Realm myRealm, final RealmList<ItemCardapio> itens){
        myRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(itens);
            }
        });
    }

    public static ArrayList<ItemCardapio> basicQuery(Realm realm, Date data, int refeicao) {
        RealmResults<ItemCardapio> results = realm.where(ItemCardapio.class).equalTo("data",data ).equalTo("refeicao",refeicao).findAll();
        ArrayList<ItemCardapio> itens = new ArrayList();
        for(ItemCardapio item : results){
            itens.add(item);
        }
        return itens;
    }
}
