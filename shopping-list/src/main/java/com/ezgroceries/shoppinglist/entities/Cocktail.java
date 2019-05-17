package com.ezgroceries.shoppinglist.entities;

import com.ezgroceries.shoppinglist.util.StringSetConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cocktail")
public class Cocktail {

    @Id
    private UUID id;

    private String idDrink;
    private String name;

    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;

}
