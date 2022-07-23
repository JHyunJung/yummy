package com.yummy.domain.ingredient.service;

import com.yummy.domain.ingredient.IngredientDto;
import com.yummy.domain.ingredient.IngredientRepository;
import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.ingredient.model.IngredientType;
import com.yummy.domain.ingredient.model.Storage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class IngredientServiceTest {


    @Autowired
    private IngredientService ingredientServicel;
    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    void getIngredient() {

        IngredientDto test = IngredientDto.builder()
                .name("테스트")
                .storage(Storage.FREEZE)
                .shelfLife(30)
                .type(IngredientType.FISH)
                .build();

        Ingredient testId = ingredientRepository.save(test.toEntity());

        Ingredient result = ingredientRepository.findById(testId.getId()).get();

        assertEquals(test.getName(), result.getName());


    }

    @Test
    void save() {
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}