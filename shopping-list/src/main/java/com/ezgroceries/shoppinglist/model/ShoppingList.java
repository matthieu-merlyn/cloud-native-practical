package com.ezgroceries.shoppinglist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingList {

    private UUID shoppingListId;
    private String name;
    private List<String> ingredients;

    public ShoppingList(UUID shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = new ArrayList<>();
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

    public List<String> getIngredients() {
        return ingredients;
    }

}
