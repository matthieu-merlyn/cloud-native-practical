package com.ezgroceries.shoppinglist.entities;

import com.ezgroceries.shoppinglist.util.StringSetConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cocktail")
public class CocktailEntity {

    @Id
    private UUID id;

    @Column(name = "id_drink")
    private String idDrink;

    private String name;

    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;

    public CocktailEntity() {
        // default constructor necessary for Hibernate reflection
    }

    public CocktailEntity(UUID id, String idDrink, String name) {
        this.id = id;
        this.idDrink = idDrink;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getIdDrink() {
        return idDrink;
    }

}
