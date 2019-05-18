package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entities.ShoppingListEntity;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ShoppingListEntity> getAllShoppingLists() {
        return null;
    }

    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        ShoppingListEntity shoppingListEntity = shoppingListRepository.save(new ShoppingListEntity(shoppingList.getName()));
        return transformShoppingList(shoppingListEntity);
    }

    private ShoppingList transformShoppingList(ShoppingListEntity shoppingListEntity) {
        return new ShoppingList(shoppingListEntity.getId(), shoppingListEntity.getName());
    }

    // public ShoppingListEntity create(ShoppingListEntity shoppingList) {
    //     ...
    // }

}
