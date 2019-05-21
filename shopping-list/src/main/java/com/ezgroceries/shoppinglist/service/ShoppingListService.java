package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entities.ShoppingListEntity;
import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public ShoppingList addCocktailsToShoppingList(String shoppingListId, List<Cocktail> cocktails) {
        Optional<ShoppingListEntity> shoppingListEntity = shoppingListRepository.findById(UUID.fromString(shoppingListId));
        shoppingListEntity.ifPresent(shoppingListEntity1 -> {
            ShoppingList existingShoppingList = transformShoppingList(shoppingListEntity1);

        });

        // if (shoppingListEntity.isPresent()) {
        //     transformShoppingList(shoppingListEntity)
        // } else {
        //     throw new RuntimeException("Shopping list not found for ID: " + shoppingListId);
        // }



        return null;
    }

    private ShoppingList transformShoppingList(ShoppingListEntity shoppingListEntity) {
        return new ShoppingList(shoppingListEntity.getId(), shoppingListEntity.getName());
    }

}
