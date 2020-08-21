package com.ezgroceries.shoppinglistnew.controller;

import com.ezgroceries.shoppinglistnew.model.Cocktail;
import com.ezgroceries.shoppinglistnew.model.ShoppingList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    @GetMapping
    public List<ShoppingList> getAllShoppingLists()  {
        return getDummyResources();
    }

    @GetMapping(value = "/{shoppingListId}")
    public ShoppingList getSpecificShoppingList(@PathVariable UUID shoppingListId) {
        return new ShoppingList(
                UUID.fromString("90689338-499a-4c49-af90-f1e73068ad4f"),
                "Stephanie's Birthday",
                Arrays.asList("Tequila", "Triple Sec", "Lime Juice", "Salt", "Blue Curacao")
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingList createShoppingList(@RequestBody ShoppingList newShoppingList) {
        newShoppingList.setShoppingListId(UUID.randomUUID());
        return newShoppingList;
    }

    @PostMapping(value = "/{shoppingListId}/cocktails")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Cocktail> addCocktailsToShoppingList(@PathVariable String shoppingListId, @RequestBody List<Cocktail> cocktails) {
        return cocktails;
    }

    private List<ShoppingList> getDummyResources() {
        return Arrays.asList(
                new ShoppingList(
                        UUID.fromString("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"),
                        "Stephanie's Birthday",
                        Arrays.asList("Tequila", "Triple Sec", "Lime Juice", "Salt", "Blue Curacao")
                ),
                new ShoppingList(
                        UUID.fromString("6c7d09c2-8a25-4d54-a979-25ae779d2465"),
                        "My Birthday",
                        Arrays.asList("Tequila", "Triple Sec", "Lime Juice", "Salt", "Blue Curacao")
                )
        );
    }

}
