package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.model.ShoppingList;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ShoppingListService {

    private Map<UUID, ShoppingList> shoppingLists = new HashMap<>();

    public ShoppingList addShoppingList(ShoppingList shoppingList) {
        shoppingList.setShoppingListId(UUID.randomUUID());
        shoppingLists.put(shoppingList.getShoppingListId(), shoppingList);
        return shoppingList;
    }

}
