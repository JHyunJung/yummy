package com.yummy.domain.ingredient;

import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.ingredient.model.IngredientType;
import com.yummy.domain.ingredient.model.Storage;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("Describe: IngredientRepositry Class")
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;
    final String name = "사과";
    final Storage storage = Storage.COLD;
    final int shelfLife = 30;
    final IngredientType type = IngredientType.FRUIT;

    @Nested
    @DisplayName("Describe: Save Method")
    class Describe_save {

        @BeforeEach
        void prepare() {
            ingredientRepository.deleteAll();
        }

        @Nested
        @DisplayName("Context: with a ingredient")
        class Context_with_ingredient {
            final Ingredient givenIngredient = Ingredient.builder()
                    .name(name)
                    .storage(storage)
                    .shelfLife(shelfLife)
                    .type(type)
                    .build();
            @Test
            @DisplayName("It saves a object and return object")
            void it_saves_obj_and_returns_a_saved_obj() {
                Assertions.assertNull(givenIngredient.getId(),
                        "저장되지 않은 객체는 아이디가 null 이다.");

                final Ingredient saved = ingredientRepository.save(givenIngredient);

                Assertions.assertNotNull(saved.getId(),
                        "저장된 객체는 아이디가 추가되어 있다");
                Assertions.assertEquals(saved.getName(), name);
            }
        }
    }

    @Nested
    @DisplayName("Describe: existsByName Method")
    class Describe_existsByName {

        @BeforeEach
        void prepare() {
            ingredientRepository.deleteAll();
        }

        @Nested
        @DisplayName("Context: with a ingredient")
        class Context_with_ingredient {
            final Ingredient givenIngredient = Ingredient.builder()
                    .name(name)
                    .storage(storage)
                    .shelfLife(shelfLife)
                    .type(type)
                    .build();
            @Test
            @DisplayName("It is existed and return true")
            void it_is_existed_and_return_true() {
                ingredientRepository.save(givenIngredient);
                final boolean existence = ingredientRepository.existsByName(name);
                assertTrue(existence);
            }

            @Test
            @DisplayName("It is not existed and return false")
            void it_is_not_existed_and_return_true() {
                final boolean existence = ingredientRepository.existsByName(name);
                assertFalse(existence);
            }
        }
    }

}
