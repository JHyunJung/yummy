package com.yummy.domain.ingredient;

import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.ingredient.model.IngredientType;
import com.yummy.domain.ingredient.model.Storage;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class IngredientRepositoryTest {

    @Autowired
    IngredientRepository ingredientRepository;

    @BeforeEach
    public void cleanup(){
        ingredientRepository.deleteAll();
    }

    @Test
    public void 재료저장_불러오기(){
        //given
        String name = "소고기";
        Storage storage = Storage.FREEZE;
        int shelfLife = 30;
        IngredientType ingredientType = IngredientType.MEAT;
        //when
        ingredientRepository.save(Ingredient.builder()
                .name(name)
                .storage(storage)
                .shelfLife(shelfLife)
                .type(ingredientType)
                .build());

        List<Ingredient> ingredientList = ingredientRepository.findAll();
        //then
        Ingredient ingredient = ingredientList.get(0);
        assertEquals(ingredient.getName(), name);
        assertEquals(ingredient.getShelfLife(), shelfLife);
        assertEquals(ingredient.getStorage(), storage);
    }

    @Test
    public void BaseTimeEntity_확인(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        String name = "소고기";
        Storage storage = Storage.FREEZE;
        int shelfLife = 30;
        IngredientType ingredientType = IngredientType.MEAT;
        ingredientRepository.save(Ingredient.builder()
                .name(name)
                .storage(storage)
                .shelfLife(shelfLife)
                .type(ingredientType)
                .build());
        //when
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        //then
        Ingredient ingredient = ingredientList.get(0);

        Assertions.assertTrue(ingredient.getCreateDate().isAfter(now));
        Assertions.assertTrue(ingredient.getModifiedDate().isAfter(now));
    }

    @Test
    public void 재료_중복등록_체크(){

        //given
        String name = "소고기";
        Storage storage = Storage.FREEZE;
        int shelfLife = 30;
        IngredientType ingredientType = IngredientType.MEAT;
        ingredientRepository.save(Ingredient.builder()
                .name(name)
                .storage(storage)
                .shelfLife(shelfLife)
                .type(ingredientType)
                .build());
        //when
        boolean isDuplicated = ingredientRepository.existsByName(name);

        //then
        assertEquals(true, isDuplicated);

    }

}
