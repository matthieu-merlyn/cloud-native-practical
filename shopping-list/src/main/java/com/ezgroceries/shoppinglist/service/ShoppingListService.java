package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    // public ShoppingListEntity create(ShoppingListEntity shoppingList) {
    //     ...
    // }

}
