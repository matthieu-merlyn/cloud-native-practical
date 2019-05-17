package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.client.CocktailDBClient;
import com.ezgroceries.shoppinglist.client.CocktailDBResponse;
import com.ezgroceries.shoppinglist.entities.Cocktail;
import com.ezgroceries.shoppinglist.repository.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CocktailService {

    private final CocktailDBClient cocktailDBClient;
    private final CocktailRepository cocktailRepository;

    private List<Cocktail> cocktails = new ArrayList<>();

    public CocktailService(CocktailDBClient cocktailDBClient, CocktailRepository cocktailRepository) {
        this.cocktailDBClient = cocktailDBClient;
        this.cocktailRepository = cocktailRepository;
    }

    public List<Cocktail> getCocktails(String search) {

        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);
        return transformCocktailDBResponse(cocktailDBResponse);

    }

    private List<Cocktail> transformCocktailDBResponse(CocktailDBResponse cocktailDBResponse) {

        List<CocktailDBResponse.Drink> drinks = cocktailDBResponse.getDrinks();

        /** TODO for (CocktailDBResponse.Drink drink : drinks) {
            cocktails.add(new Cocktail(
                    UUID.randomUUID(),
                    drink.getStrDrink(),
                    drink.getStrGlass(),
                    drink.getStrInstructions(),
                    drink.getStrDrinkThumb(),
                    drink.getStrIngredients()
            ));
        }

        return cocktails; */

        return new ArrayList<>();

    }

}
