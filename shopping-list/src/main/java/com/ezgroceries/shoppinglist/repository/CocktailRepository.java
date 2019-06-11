package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.entity.CocktailEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface CocktailRepository extends CrudRepository<CocktailEntity, UUID> {
    List<CocktailEntity> findByIdDrinkIn(List<String> idDrinks);
    Set<CocktailEntity> findAllByIdIn(Set<UUID> cocktailIds);
    List<CocktailEntity> findByNameContainingIgnoreCase(String search);
}
