package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.entities.ShoppingListEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    @GetMapping
    public List<ShoppingListEntity> getAllShoppingLists()  {
        return new ArrayList<>();
        // TODO return getDummyResources();
    }

    @GetMapping(value = "/{shoppingListId}")
    public ShoppingListEntity getSpecificShoppingList(@PathVariable UUID shoppingListId) {
        return new ShoppingListEntity();
        /** TODO return new ShoppingListEntity(
                UUID.fromString("90689338-499a-4c49-af90-f1e73068ad4f"),
                "Stephanie's Birthday",
                Arrays.asList("Tequila", "Triple Sec", "Lime Juice", "Salt", "Blue Curacao")
        );*/
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListEntity createShoppingList(@RequestBody ShoppingListEntity newShoppingList) {
        return new ShoppingListEntity();
        /** TODO newShoppingList.setShoppingListId(UUID.randomUUID());
        return newShoppingList; */
    }

    @PostMapping(value = "/{shoppingListId}/cocktails")
    @ResponseStatus(HttpStatus.CREATED)
    public List<CocktailEntity> addCocktailsToShoppingList(@PathVariable String shoppingListId, @RequestBody List<CocktailEntity> cocktails) {
        return cocktails;
    }

}
