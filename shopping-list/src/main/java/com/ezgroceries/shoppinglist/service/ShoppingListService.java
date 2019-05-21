package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.entities.ShoppingListEntity;
import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final CocktailService cocktailService;

    public ShoppingListService(ShoppingListRepository shoppingListRepository, CocktailService cocktailService) {
        this.shoppingListRepository = shoppingListRepository;
        this.cocktailService = cocktailService;
    }

    public List<ShoppingListEntity> getAllShoppingLists() {
        return null;
    }

    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        ShoppingListEntity shoppingListEntity = shoppingListRepository.save(new ShoppingListEntity(shoppingList.getName()));
        return transformShoppingList(shoppingListEntity);
    }

    public ShoppingList addCocktailsToShoppingList(String shoppingListId, List<Cocktail> cocktails) {

        Set<CocktailEntity> cocktailEntities = cocktailService.findCocktailEntitiesById(cocktails);
        ShoppingListEntity shoppingListEntity = shoppingListRepository.findById(UUID.fromString(shoppingListId)).orElse(null);

        if(shoppingListEntity == null) {
            throw new RuntimeException("No shopping list found for ID: " + shoppingListId);
        } else {
            shoppingListEntity.setCocktails(cocktailEntities);
            return transformShoppingList(shoppingListEntity);
        }

    }

    private ShoppingList transformShoppingList(ShoppingListEntity shoppingListEntity) {
        return new ShoppingList(shoppingListEntity.getId(), shoppingListEntity.getName());
    }

}
