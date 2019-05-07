package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.model.Cocktail;
import com.ezgroceries.shoppinglist.service.CocktailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    private CocktailService cocktailService = new CocktailService();

    @GetMapping
    public List<Cocktail> getAllCocktails(@RequestParam String search) {
        return cocktailService.getAllCocktails();
    }

}
