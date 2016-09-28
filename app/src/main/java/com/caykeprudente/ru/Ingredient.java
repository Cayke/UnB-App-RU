package com.caykeprudente.ru;

/**
 * Created by cayke on 28/09/16.
 */

public class Ingredient {
    public enum Type{
        Carne, Guarnicao, Suco, Sobremesa, Vegano, Salada, Molho
    }

    private String name;
    private Type type;
    private Integer calories;

    public Ingredient(String name, Type type, Integer calories)
    {
        this.name = name;
        this.type = type;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Integer getCalories() {
        return calories;
    }
}
