package com.ezgroceries.shoppinglistnew.controller;

import com.ezgroceries.shoppinglistnew.model.Cocktail;
import com.ezgroceries.shoppinglistnew.service.CocktailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    private final CocktailService cocktailService;

    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping
    public List<Cocktail> searchCocktails(@RequestParam String search) {
        return cocktailService.searchCocktails(search);
    }

}
