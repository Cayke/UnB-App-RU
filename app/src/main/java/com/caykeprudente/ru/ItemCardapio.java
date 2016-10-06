package com.caykeprudente.ru;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ItemCardapio extends RealmObject {

    public ItemCardapio(){}

    public ItemCardapio(String name, int type, int calories, Date data, int refeicao){
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.data = data;
        this.refeicao = refeicao;
        this.pk = name+data+refeicao;
    }

    @PrimaryKey
    private String pk;
    private String name;
    private int calories;
    private Date data;
    private int type;
    private int refeicao;

    public void setName(String name){ this.name = name; }

    public void setCalories(int calories){ this.calories = calories; }

    public void setData(Date data){ this.data = data; }

    public void setType(int type){ this.type = type; }

    public void setRefeicao(int refeicao){ this.refeicao = refeicao; }

    public void setPk(){ this.pk = name+data+refeicao; }

    public String getName(){ return name; }

    public int getCalories(){ return calories; }

    public Date getData(){ return data; }

    public int getType(){ return type; }

    public int getRefeicao(){ return refeicao; }

    public String getPk(){ return pk; }

}