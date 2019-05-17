package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.entities.ShoppingListEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShoppingListRepository extends CrudRepository<ShoppingListEntity, UUID> {
}
