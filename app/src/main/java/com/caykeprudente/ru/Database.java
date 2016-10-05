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
        if (Realm.getDefaultInstance().isEmpty()) {
            RealmList<ItemCardapio> arrayList = new RealmList();
            try {
                final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date data = new Date(format.parse("03/10/2016").getTime());
                //cafe
                arrayList.add(new ItemCardapio("Leite, café, chá de camomila", Salada, 10, data, Cafe));
                arrayList.add(new ItemCardapio("Iogurte natural", Molho, 20, data, Cafe));
                arrayList.add(new ItemCardapio("Queijo Mussarela", Principal, 30, data, Cafe));
                arrayList.add(new ItemCardapio("Pao frances", Guarnicao, 40, data, Cafe));
                arrayList.add(new ItemCardapio("Creme vegetal", Vegetariano, 50, data, Cafe));
                arrayList.add(new ItemCardapio("Manteiga", Complementos, 60, data, Cafe));
                arrayList.add(new ItemCardapio("Melancia", Sobremesa, 70, data, Cafe));
                arrayList.add(new ItemCardapio("Caju", Suco, 80, data, Cafe));
                //almoco
                arrayList.add(new ItemCardapio("Mix de folhas e rabanete", Salada, 11, data, Almoco));
                arrayList.add(new ItemCardapio("Molho de manjericão", Molho, 21, data, Almoco));
                arrayList.add(new ItemCardapio("Frango à parisiense (peito)", Principal, 31, data, Almoco));
                arrayList.add(new ItemCardapio("Beterraba cozida", Guarnicao, 41, data, Almoco));
                arrayList.add(new ItemCardapio("Picadinho de soja à carioca (ptn de soja grossa escura) ", Vegetariano, 51, data, Almoco));
                arrayList.add(new ItemCardapio("Arroz c/ cenoura, arroz integral e Feijão", Complementos, 61, data, Almoco));
                arrayList.add(new ItemCardapio("Laranja", Sobremesa, 71, data, Almoco));
                arrayList.add(new ItemCardapio("Goiaba", Suco, 81, data, Almoco));
                //janta
                arrayList.add(new ItemCardapio("Acelga e tomate", Salada, 12, data, Jantar));
                arrayList.add(new ItemCardapio("Molho de laranja e mel", Molho, 22, data, Jantar));
                arrayList.add(new ItemCardapio("Bife de panela com ervilhas", Principal, 32, data, Jantar));
                arrayList.add(new ItemCardapio("Torrada", Guarnicao, 42, data, Jantar));
                arrayList.add(new ItemCardapio("Sopa de feijao com macarrao", Vegetariano, 52, data, Jantar));
                arrayList.add(new ItemCardapio("Arroz branco, arroz integral e feijao", Complementos, 62, data, Jantar));
                arrayList.add(new ItemCardapio("Melao", Sobremesa, 72, data, Jantar));
                arrayList.add(new ItemCardapio("Tangerina", Suco, 82, data, Jantar));

                //-------------------TERÇA---------------------------
                Date data2 = new Date(format.parse("04/10/2016").getTime());
                //cafe
                arrayList.add(new ItemCardapio("Leite, café, chá de hortela", Salada, 10, data2, Cafe));
                arrayList.add(new ItemCardapio("Iogurte natural", Molho, 20, data2, Cafe));
                arrayList.add(new ItemCardapio("Queijo Minas", Principal, 30, data2, Cafe));
                arrayList.add(new ItemCardapio("Pao Carequinha", Guarnicao, 40, data2, Cafe));
                arrayList.add(new ItemCardapio("Creme vegetal", Vegetariano, 50, data2, Cafe));
                arrayList.add(new ItemCardapio("Geleia", Complementos, 60, data2, Cafe));
                arrayList.add(new ItemCardapio("Banana", Sobremesa, 70, data2, Cafe));
                arrayList.add(new ItemCardapio("Melao com hortela", Suco, 80, data2, Cafe));
                //almoco
                arrayList.add(new ItemCardapio("Alface crespa e pepino", Salada, 11, data2, Almoco));
                arrayList.add(new ItemCardapio("Molho vinagrete", Molho, 21, data2, Almoco));
                arrayList.add(new ItemCardapio("Carne de sol acebolada", Principal, 31, data2, Almoco));
                arrayList.add(new ItemCardapio("Mandioca cozida", Guarnicao, 41, data2, Almoco));
                arrayList.add(new ItemCardapio("Lentilha com legumes ", Vegetariano, 51, data2, Almoco));
                arrayList.add(new ItemCardapio("Arroz banco, arroz integral e feijao", Complementos, 61, data2, Almoco));
                arrayList.add(new ItemCardapio("Mamao", Sobremesa, 71, data2, Almoco));
                arrayList.add(new ItemCardapio("Limao", Suco, 81, data2, Almoco));
                //janta
                arrayList.add(new ItemCardapio("Alface roxa e cenourinha", Salada, 12, data2, Jantar));
                arrayList.add(new ItemCardapio("Molho de ervas ao parmessao", Molho, 22, data2, Jantar));
                arrayList.add(new ItemCardapio("Omelete verde com cabelo", Principal, 32, data2, Jantar));
                arrayList.add(new ItemCardapio("Sopa rica de agua", Guarnicao, 42, data2, Jantar));
                arrayList.add(new ItemCardapio("Grao de bico com couve no vapor", Vegetariano, 52, data2, Jantar));
                arrayList.add(new ItemCardapio("Arroz branco, arroz integral e feijao", Complementos, 62, data2, Jantar));
                arrayList.add(new ItemCardapio("Maça", Sobremesa, 72, data2, Jantar));
                arrayList.add(new ItemCardapio("Manga", Suco, 82, data2, Jantar));

                //-------------------QUARTA--------------------------
                Date data3 = new Date(format.parse("05/10/2016").getTime());
                //cafe
                arrayList.add(new ItemCardapio("Leite, café, chá de camomila", Salada, 10, data3, Cafe));
                arrayList.add(new ItemCardapio("Iogurte natural", Molho, 20, data3, Cafe));
                arrayList.add(new ItemCardapio("Queijo Mussarela", Principal, 30, data3, Cafe));
                arrayList.add(new ItemCardapio("Pao frances", Guarnicao, 40, data3, Cafe));
                arrayList.add(new ItemCardapio("Creme vegetal", Vegetariano, 50, data3, Cafe));
                arrayList.add(new ItemCardapio("Manteiga", Complementos, 60, data3, Cafe));
                arrayList.add(new ItemCardapio("Melancia", Sobremesa, 70, data3, Cafe));
                arrayList.add(new ItemCardapio("Caju", Suco, 80, data3, Cafe));
                //almoco
                arrayList.add(new ItemCardapio("Mix de folhas e rabanete", Salada, 11, data3, Almoco));
                arrayList.add(new ItemCardapio("Molho de manjericão", Molho, 21, data3, Almoco));
                arrayList.add(new ItemCardapio("Frango à parisiense (peito)", Principal, 31, data3, Almoco));
                arrayList.add(new ItemCardapio("Beterraba cozida", Guarnicao, 41, data3, Almoco));
                arrayList.add(new ItemCardapio("Picadinho de soja à carioca (ptn de soja grossa escura) ", Vegetariano, 51, data3, Almoco));
                arrayList.add(new ItemCardapio("Arroz c/ cenoura, arroz integral e Feijão", Complementos, 61, data3, Almoco));
                arrayList.add(new ItemCardapio("Laranja", Sobremesa, 71, data3, Almoco));
                arrayList.add(new ItemCardapio("Goiaba", Suco, 81, data3, Almoco));
                //janta
                arrayList.add(new ItemCardapio("Acelga e tomate", Salada, 12, data3, Jantar));
                arrayList.add(new ItemCardapio("Molho de laranja e mel", Molho, 22, data3, Jantar));
                arrayList.add(new ItemCardapio("Bife de panela com ervilhas", Principal, 32, data3, Jantar));
                arrayList.add(new ItemCardapio("Torrada", Guarnicao, 42, data3, Jantar));
                arrayList.add(new ItemCardapio("Sopa de feijao com macarrao", Vegetariano, 52, data3, Jantar));
                arrayList.add(new ItemCardapio("Arroz branco, arroz integral e feijao", Complementos, 62, data3, Jantar));
                arrayList.add(new ItemCardapio("Melao", Sobremesa, 72, data3, Jantar));
                arrayList.add(new ItemCardapio("Tangerina", Suco, 82, data3, Jantar));

                //-------------------QUINTA---------------------------
                Date data4 = new Date(format.parse("06/10/2016").getTime());
                //cafe
                arrayList.add(new ItemCardapio("Leite, café, chá de hortela", Salada, 10, data4, Cafe));
                arrayList.add(new ItemCardapio("Iogurte natural", Molho, 20, data4, Cafe));
                arrayList.add(new ItemCardapio("Queijo Minas", Principal, 30, data4, Cafe));
                arrayList.add(new ItemCardapio("Pao Carequinha", Guarnicao, 40, data4, Cafe));
                arrayList.add(new ItemCardapio("Creme vegetal", Vegetariano, 50, data4, Cafe));
                arrayList.add(new ItemCardapio("Geleia", Complementos, 60, data4, Cafe));
                arrayList.add(new ItemCardapio("Banana", Sobremesa, 70, data4, Cafe));
                arrayList.add(new ItemCardapio("Melao com hortela", Suco, 80, data4, Cafe));
                //almoco
                arrayList.add(new ItemCardapio("Alface crespa e pepino", Salada, 11, data4, Almoco));
                arrayList.add(new ItemCardapio("Molho vinagrete", Molho, 21, data4, Almoco));
                arrayList.add(new ItemCardapio("Carne de sol acebolada", Principal, 31, data4, Almoco));
                arrayList.add(new ItemCardapio("Mandioca cozida", Guarnicao, 41, data4, Almoco));
                arrayList.add(new ItemCardapio("Lentilha com legumes ", Vegetariano, 51, data4, Almoco));
                arrayList.add(new ItemCardapio("Arroz banco, arroz integral e feijao", Complementos, 61, data4, Almoco));
                arrayList.add(new ItemCardapio("Mamao", Sobremesa, 71, data4, Almoco));
                arrayList.add(new ItemCardapio("Limao", Suco, 81, data4, Almoco));
                //janta
                arrayList.add(new ItemCardapio("Alface roxa e cenourinha", Salada, 12, data4, Jantar));
                arrayList.add(new ItemCardapio("Molho de ervas ao parmessao", Molho, 22, data4, Jantar));
                arrayList.add(new ItemCardapio("Omelete verde com cabelo", Principal, 32, data4, Jantar));
                arrayList.add(new ItemCardapio("Sopa rica de agua", Guarnicao, 42, data4, Jantar));
                arrayList.add(new ItemCardapio("Grao de bico com couve no vapor", Vegetariano, 52, data4, Jantar));
                arrayList.add(new ItemCardapio("Arroz branco, arroz integral e feijao", Complementos, 62, data4, Jantar));
                arrayList.add(new ItemCardapio("Maça", Sobremesa, 72, data4, Jantar));
                arrayList.add(new ItemCardapio("Manga", Suco, 82, data4, Jantar));

                //-------------------SEXTA---------------------------
                Date data5 = new Date(format.parse("07/10/2016").getTime());
                //cafe
                arrayList.add(new ItemCardapio("Leite, café, chá de camomila", Salada, 10, data5, Cafe));
                arrayList.add(new ItemCardapio("Iogurte natural", Molho, 20, data5, Cafe));
                arrayList.add(new ItemCardapio("Queijo Mussarela", Principal, 30, data5, Cafe));
                arrayList.add(new ItemCardapio("Pao frances", Guarnicao, 40, data5, Cafe));
                arrayList.add(new ItemCardapio("Creme vegetal", Vegetariano, 50, data5, Cafe));
                arrayList.add(new ItemCardapio("Manteiga", Complementos, 60, data5, Cafe));
                arrayList.add(new ItemCardapio("Melancia", Sobremesa, 70, data5, Cafe));
                arrayList.add(new ItemCardapio("Caju", Suco, 80, data5, Cafe));
                //almoco
                arrayList.add(new ItemCardapio("Mix de folhas e rabanete", Salada, 11, data5, Almoco));
                arrayList.add(new ItemCardapio("Molho de manjericão", Molho, 21, data5, Almoco));
                arrayList.add(new ItemCardapio("Frango à parisiense (peito)", Principal, 31, data5, Almoco));
                arrayList.add(new ItemCardapio("Beterraba cozida", Guarnicao, 41, data5, Almoco));
                arrayList.add(new ItemCardapio("Picadinho de soja à carioca (ptn de soja grossa escura) ", Vegetariano, 51, data5, Almoco));
                arrayList.add(new ItemCardapio("Arroz c/ cenoura, arroz integral e Feijão", Complementos, 61, data5, Almoco));
                arrayList.add(new ItemCardapio("Laranja", Sobremesa, 71, data5, Almoco));
                arrayList.add(new ItemCardapio("Goiaba", Suco, 81, data5, Almoco));
                //janta
                arrayList.add(new ItemCardapio("Acelga e tomate", Salada, 12, data5, Jantar));
                arrayList.add(new ItemCardapio("Molho de laranja e mel", Molho, 22, data5, Jantar));
                arrayList.add(new ItemCardapio("Bife de panela com ervilhas", Principal, 32, data5, Jantar));
                arrayList.add(new ItemCardapio("Torrada", Guarnicao, 42, data5, Jantar));
                arrayList.add(new ItemCardapio("Sopa de feijao com macarrao", Vegetariano, 52, data5, Jantar));
                arrayList.add(new ItemCardapio("Arroz branco, arroz integral e feijao", Complementos, 62, data5, Jantar));
                arrayList.add(new ItemCardapio("Melao", Sobremesa, 72, data5, Jantar));
                arrayList.add(new ItemCardapio("Tangerina", Suco, 82, data5, Jantar));

            } catch (ParseException e) {
                e.printStackTrace();
            }

            inserirItemCardapio(Realm.getDefaultInstance(), arrayList);
        }
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
