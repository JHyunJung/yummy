package com.yummy.domain.ingredient.service;

import com.yummy.domain.ingredient.IngredientDto;
import com.yummy.domain.ingredient.IngredientRepository;
import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.ingredient.model.IngredientType;
import com.yummy.domain.ingredient.model.Storage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class IngredientServiceTest {


    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private IngredientRepository ingredientRepository;

    @AfterEach
    public void cleanup(){
        ingredientRepository.deleteAll();
    }

    @Test
    void saveAndGetTest() {

        IngredientDto test = IngredientDto.builder()
                .name("테스트")
                .storage(Storage.FREEZE)
                .shelfLife(30)
                .type(IngredientType.FISH)
                .build();

        Long testId = ingredientService.save(test);
        IngredientDto result = ingredientService.getById(testId);

        assertEquals(test.getName(), result.getName());
        assertEquals(test.getShelfLife(), result.getShelfLife());
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {

        IngredientDto test = IngredientDto.builder()
                .name("테스트")
                .storage(Storage.FREEZE)
                .shelfLife(30)
                .type(IngredientType.FISH)
                .build();

        Ingredient testId = ingredientRepository.save(test.toEntity());
        Ingredient result = ingredientRepository.findById(testId.getId()).get();

        assertEquals(test.getName(), result.getName());
        assertEquals(5, result.getId());
    }
}