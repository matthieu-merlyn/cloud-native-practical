package com.ezgroceries.shoppinglist.resource;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListResource {

    private ShoppingListService shoppingListService = new ShoppingListService();


    @GetMapping
    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListService.getAllShoppingLists();
    }

    @GetMapping(value = "/{shoppingListId}")
    public ShoppingList getSpecificShoppingList(@PathVariable UUID shoppingListId) {
        return shoppingListService.getSpecificShoppingList(shoppingListId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingList createShoppingList(@RequestBody ShoppingList newShoppingList) {
        return shoppingListService.addShoppingList(newShoppingList);
    }

    // TODO
    // @PostMapping(value = "/{shoppingListId}/cocktails")
    // public CocktailResource getCocktailResource() { return new CocktailResource(); }
}
