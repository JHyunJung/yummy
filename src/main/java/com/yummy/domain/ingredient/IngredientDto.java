package com.yummy.domain.ingredient;

import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.ingredient.model.IngredientType;
import com.yummy.domain.ingredient.model.Storage;
import com.yummy.domain.userstorage.UserStorageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDto{

    private Long id;
    private String name;
    private Storage storage;
    private int shelfLife;
    private IngredientType type;

    @Builder
    public IngredientDto(Long id, String name, Storage storage, int shelfLife, IngredientType type) {
        this.id = id;
        this.name = name;
        this.storage = storage;
        this.shelfLife = shelfLife;
        this.type = type;
    }

    public IngredientDto(Ingredient ingredient){
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this. storage = ingredient.getStorage();
        this.shelfLife = ingredient.getShelfLife();
        this.type = ingredient.getType();
    }

    public Ingredient toEntity(){
        return Ingredient.builder()
                .id(id)
                .name(name)
                .storage(storage)
                .shelfLife(shelfLife)
                .type(type)
                .build();
    }
}
