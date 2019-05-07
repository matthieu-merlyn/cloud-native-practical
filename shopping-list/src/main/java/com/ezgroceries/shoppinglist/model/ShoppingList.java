package com.ezgroceries.shoppinglist.model;

import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShoppingList {

    private UUID shoppingListId;
    private String name;
    private Map<UUID, Cocktail> cocktails = new HashMap<>();

    public ShoppingList(UUID shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Map<UUID, Cocktail> getCocktails() {
        return cocktails;
    }

    public void setCocktails(Map<UUID, Cocktail> cocktails) {
        this.cocktails = cocktails;
    }
}
