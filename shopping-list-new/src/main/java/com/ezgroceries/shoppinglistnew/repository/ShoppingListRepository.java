package com.ezgroceries.shoppinglistnew.repository;

import com.ezgroceries.shoppinglistnew.entities.ShoppingListEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShoppingListRepository extends CrudRepository<ShoppingListEntity, UUID> {

}
