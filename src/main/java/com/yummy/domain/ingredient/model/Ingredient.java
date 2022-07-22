package com.yummy.domain.ingredient.model;

import com.yummy.domain.ingredient.IngredientDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@SuperBuilder
@Getter
@Entity
public class Ingredient extends Food {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IngredientType type;

    public void update(IngredientDto ingredientDto){
        this.name = ingredientDto.getName();
        this.storage = ingredientDto.getStorage();
        this.shelfLife = ingredientDto.getShelfLife();
        this.type = ingredientDto.getType();
    }
}
