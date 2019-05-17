package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.entities.Cocktail;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CocktailRepository extends CrudRepository<Cocktail, UUID> {
}
