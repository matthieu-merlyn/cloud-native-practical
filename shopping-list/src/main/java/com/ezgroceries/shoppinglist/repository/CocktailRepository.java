package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CocktailRepository extends CrudRepository<CocktailEntity, UUID> {
    List<CocktailEntity> findByIdDrinkIn(List<String> idDrinks);
}
