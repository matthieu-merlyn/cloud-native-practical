package com.ezgroceries.shoppinglistnew.controller;

import com.ezgroceries.shoppinglistnew.model.Cocktail;
import com.ezgroceries.shoppinglistnew.model.ShoppingList;
import com.ezgroceries.shoppinglistnew.service.ShoppingListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.createShoppingList(shoppingList);
    }

    @PostMapping(value = "/{shoppingListId}/cocktails")
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingList addCocktailsToShoppingList(@PathVariable UUID shoppingListId, @RequestBody List<Cocktail> cocktails) {
        return shoppingListService.addCocktailsToShoppingList(shoppingListId, cocktails);
    }

    @GetMapping(value = "/{shoppingListId}")
    public ShoppingList getSpecificShoppingList(@PathVariable UUID shoppingListId) {
        return shoppingListService.getSpecificShoppingList(shoppingListId);
    }

    @GetMapping
    public List<ShoppingList> getAllShoppingLists()  {
        return shoppingListService.getAllShoppingLists();
    }

}
