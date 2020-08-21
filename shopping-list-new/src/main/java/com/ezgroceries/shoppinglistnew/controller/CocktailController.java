package com.ezgroceries.shoppinglistnew.controller;

import com.ezgroceries.shoppinglistnew.client.CocktailDBClient;
import com.ezgroceries.shoppinglistnew.model.Cocktail;
import com.ezgroceries.shoppinglistnew.model.CocktailDBResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    private CocktailDBClient cocktailDBClient;
    private List<Cocktail> cocktails = new ArrayList<>();

    @Autowired
    public CocktailController(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }

    @GetMapping
    public List<Cocktail> getAllCocktails(@RequestParam String search) {
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);
        return transformCocktailDBResponse(cocktailDBResponse);
    }

    private List<Cocktail> transformCocktailDBResponse(CocktailDBResponse cocktailDBResponse) {
        List<CocktailDBResponse.Drink> drinks = cocktailDBResponse.getDrinks();

        for (CocktailDBResponse.Drink drink : drinks) {
            cocktails.add(new Cocktail(
                    UUID.randomUUID(),
                    drink.getStrDrink(),
                    drink.getStrGlass(),
                    drink.getStrInstructions(),
                    drink.getStrDrinkThumb(),
                    drink.getStrIngredients()
            ));
        }

        return cocktails;
    }

    // private List<Cocktail> getDummyResources() {
    //     return Arrays.asList(
    //             new Cocktail(
    //                     UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"), "Margerita",
    //                     "Cocktail glass",
    //                     "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
    //                     "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
    //                     Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt")),
    //             new Cocktail(
    //                     UUID.fromString("d615ec78-fe93-467b-8d26-5d26d8eab073"), "Blue Margerita",
    //                     "Cocktail glass",
    //                     "Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..",
    //                     "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
    //                     Arrays.asList("Tequila", "Blue Curacao", "Lime juice", "Salt")));
    //
    // }
}
