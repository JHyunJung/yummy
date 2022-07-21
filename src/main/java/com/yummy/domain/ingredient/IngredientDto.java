package com.yummy.domain.ingredient;

import com.yummy.domain.food.Storage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class IngredientDto{

    private String name;
    private Storage storage;
    private int shelfLife;
    private IngredientType type;

    @Builder
    public IngredientDto(String name, Storage storage, int shelfLife, IngredientType type) {
        this.name = name;
        this.storage = storage;
        this.shelfLife = shelfLife;
        this.type = type;
    }

    public IngredientDto(Ingredient ingredient){
        this.name = ingredient.getName();
        this. storage = ingredient.getStorage();
        this.shelfLife = ingredient.getShelfLife();
        this.type = ingredient.getType();
    }

    public Ingredient toEntity(){
        return Ingredient.builder()
                .name(name)
                .storage(storage)
                .shelfLife(shelfLife)
                .type(type)
                .build();
    }
}
