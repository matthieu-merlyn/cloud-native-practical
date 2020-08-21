package com.ezgroceries.shoppinglistnew.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ShoppingList {

    private UUID shoppingListId;
    private String name;
    private Set<String> ingredients;

    public ShoppingList(UUID shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = new HashSet<>();
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

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }
}
