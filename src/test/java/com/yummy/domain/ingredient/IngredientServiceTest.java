package com.yummy.domain.ingredient;

import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.ingredient.model.IngredientType;
import com.yummy.domain.ingredient.model.Storage;
import com.yummy.domain.ingredient.service.IngredientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IngredientServiceTest {

    @Autowired
    IngredientService ingredientService;
    @Autowired
    IngredientRepository ingredientRepository;

    @BeforeEach
    public void cleanup() {
        ingredientRepository.deleteAll();
    }

    @Test
    public void 재료저장() {
        //given
        String name = "소고기";
        Storage storage = Storage.FREEZE;
        int shelfLife = 30;
        IngredientType ingredientType = IngredientType.MEAT;

        IngredientDto ingredientDto = IngredientDto.builder()
                .name(name)
                .storage(storage)
                .shelfLife(shelfLife)
                .type(ingredientType)
                .build();
        //when
        ingredientService.save(ingredientDto);

        List<Ingredient> ingredientList = ingredientRepository.findAll();
        //then
        Ingredient ingredient = ingredientList.get(0);
        assertEquals(ingredient.getName(), name);
        assertEquals(ingredient.getShelfLife(), shelfLife);
        assertEquals(ingredient.getStorage(), storage);
    }

    @Test
    public void 재료찾기_아이디(){
        //given
        String name = "소고기";
        Storage storage = Storage.FREEZE;
        int shelfLife = 30;
        IngredientType ingredientType = IngredientType.MEAT;

        IngredientDto ingredientDto = IngredientDto.builder()
                .name(name)
                .storage(storage)
                .shelfLife(shelfLife)
                .type(ingredientType)
                .build();
        //when
        Long id = ingredientService.save(ingredientDto);
        IngredientDto ingredient = ingredientService.getById(id);
        //then

        assertEquals(ingredient.getId(), id);
        assertEquals(ingredient.getName(), name);
        assertEquals(ingredient.getShelfLife(), shelfLife);
        assertEquals(ingredient.getStorage(), storage);
    }

    @Test
    public void 재료_업데이트(){
        //given
        String asName = "소고기";
        Storage asStorage = Storage.FREEZE;
        int asShelfLife = 30;
        IngredientType asIngredientType = IngredientType.MEAT;

        String toName = "양고기";
        Storage toStorage = Storage.COLD;
        int toShelfLife = 60;

        IngredientDto ingredientDto = IngredientDto.builder()
                .name(asName)
                .storage(asStorage)
                .shelfLife(asShelfLife)
                .type(asIngredientType)
                .build();
        //when
        Long id = ingredientService.save(ingredientDto);
        IngredientDto updateDto = IngredientDto.builder()
                .name(toName)
                .storage(toStorage)
                .shelfLife(toShelfLife)
                .build();
        ingredientService.update(id, updateDto);
        //then
        IngredientDto updatedDto = ingredientService.getById(id);

        assertEquals(updatedDto.getName(), toName);
        assertEquals(updatedDto.getShelfLife(), toShelfLife);
        assertEquals(updatedDto.getStorage(), toStorage);
    }

}
