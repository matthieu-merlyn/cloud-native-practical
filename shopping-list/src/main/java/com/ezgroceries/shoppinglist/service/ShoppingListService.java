package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.model.ShoppingList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ShoppingListService {

    private Map<UUID, ShoppingList> shoppingLists = new HashMap<>();

    public List<ShoppingList> getAllShoppingLists() {
        return new ArrayList<>(shoppingLists.values());
    }

    public ShoppingList getSpecificShoppingList(UUID shoppingListId) {
        ShoppingList shoppingList = shoppingLists.get(shoppingListId);
        return shoppingList;
    }

    public ShoppingList addShoppingList(ShoppingList shoppingList) {
        shoppingList.setShoppingListId(UUID.randomUUID());
        shoppingLists.put(shoppingList.getShoppingListId(), shoppingList);
        return shoppingList;
    }

}
