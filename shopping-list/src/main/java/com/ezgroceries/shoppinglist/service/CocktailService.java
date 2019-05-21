package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.client.CocktailDBClient;
import com.ezgroceries.shoppinglist.client.CocktailDBResponse;
import com.ezgroceries.shoppinglist.client.CocktailDBResponse.Drink;
import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.repository.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CocktailService {

    private final CocktailDBClient cocktailDBClient;
    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailDBClient cocktailDBClient, CocktailRepository cocktailRepository) {
        this.cocktailDBClient = cocktailDBClient;
        this.cocktailRepository = cocktailRepository;
    }

    public List<Cocktail> searchCocktails(String search) {
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);
        return mergeCocktails(cocktailDBResponse.getDrinks());
    }

    private List<Cocktail> mergeCocktails(List<Drink> drinks) {
        //Get all the idDrink attributes
        List<String> ids = drinks.stream().map(Drink::getIdDrink).collect(Collectors.toList());

        //Get all the ones we already have from our DB, use a Map for convenient lookup
        Map<String, CocktailEntity> existingEntityMap = cocktailRepository.findByIdDrinkIn(ids).stream()
                .collect(Collectors.toMap(CocktailEntity::getIdDrink, o -> o, (o, o2) -> o));

        //Stream over all the drinks, map them to the existing ones, persist a new one if not existing
        Map<String, CocktailEntity> allEntityMap = drinks.stream().map(drink -> {
            CocktailEntity cocktailEntity = existingEntityMap.get(drink.getIdDrink());
            if (cocktailEntity == null) {
                CocktailEntity newCocktailEntity = new CocktailEntity(UUID.randomUUID(), drink.getIdDrink(), drink.getStrDrink());
                cocktailEntity = cocktailRepository.save(newCocktailEntity);
            }
            return cocktailEntity;
        }).collect(Collectors.toMap(CocktailEntity::getIdDrink, o -> o, (o, o2) -> o));

        //Merge drinks and our entities, transform to CocktailResource instances
        return mergeAndTransformCocktails(drinks, allEntityMap);
    }

    private List<Cocktail> mergeAndTransformCocktails(List<Drink> drinks, Map<String, CocktailEntity> allEntityMap) {
        return drinks.stream().map(drink ->
                new Cocktail(allEntityMap.get(
                        drink.getIdDrink()).getId(),
                        drink.getStrDrink(),
                        drink.getStrGlass(),
                        drink.getStrInstructions(),
                        drink.getStrDrinkThumb(),
                        drink.getStrIngredients()))
                .collect(Collectors.toList());
    }

    public Set<CocktailEntity> findCocktailEntitiesById(List<Cocktail> cocktails) {
        Set<UUID> cocktailIds = cocktails.stream().map(Cocktail::getCocktailId).collect(Collectors.toSet());
        return cocktailRepository.findAllById(cocktailIds);
    }
}
