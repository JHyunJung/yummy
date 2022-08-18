package com.yummy.domain.ingredient.model;

import com.yummy.domain.ingredient.IngredientDto;
import com.yummy.global.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Entity
public class Ingredient extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENT_ID")
    private  Long id;

    @Column(nullable = false)
    private  String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Storage storage;

    @Column
    private  int shelfLife;
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
