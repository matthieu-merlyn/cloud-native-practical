package com.ezgroceries.shoppinglist.resource;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.service.CocktailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailResource {

    private CocktailService cocktailService = new CocktailService();

    @GetMapping
    public List<Cocktail> getAllCocktails(@RequestParam String search) {
        return cocktailService.getAllCocktails();
    }

    // @PostMapping
    // public List<UUID> addCocktailsToList
}
