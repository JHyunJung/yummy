package com.yummy.domain.ingredient;

import com.yummy.domain.ingredient.model.IngredientType;
import com.yummy.domain.ingredient.model.Storage;
import com.yummy.domain.ingredient.service.IngredientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Describe: IngredientService Class")
public class IngredientServiceTest {

    @Autowired
    private IngredientService ingredientService;
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
        @DisplayName("Context: with a ingredientDto")
        class Context_with_ingredientDto {
            final IngredientDto givenDto = IngredientDto.builder()
                    .name(name)
                    .storage(storage)
                    .shelfLife(shelfLife)
                    .type(type)
                    .build();

            @Test
            @DisplayName("It saves a dto and return Long Id")
            void it_saves_dto_and_returns_long_id() {
                assertNull(givenDto.getId(),
                        "저장되지 않은 객체는 아이디가 null이다.");

                final Long id = ingredientService.save(givenDto);
                final IngredientDto foundDto = ingredientService.getById(id);
                assertEquals(id, foundDto.getId());
            }
        }
    }

    @Nested
    @DisplayName("Describe: getById Method")
    class Describe_getById {
        @BeforeEach
        void prepare() {
            ingredientRepository.deleteAll();
        }

        @Nested
        @DisplayName("Context: with a Long id")
        class Context_with_Long_id {
            final IngredientDto givenDto = IngredientDto.builder()
                    .name(name)
                    .storage(storage)
                    .shelfLife(shelfLife)
                    .type(type)
                    .build();

            @Test
            @DisplayName("It find a ingredient by id and return dto")
            void it_find_ingredient_by_id_return_dto() {

                final Long savedId = ingredientService.save(givenDto);
                IngredientDto foundDto = ingredientService.getById(savedId);

                assertEquals(foundDto.getName(), givenDto.getName());
            }

            @Test
            @DisplayName("It can't find a ingredient by id and throw IllegalArgumentException")
            void it_cannot_find_ingredient_by_id_throw_exception() {

                final Long foundId = 100L;
                Throwable exception = assertThrows(RuntimeException.class, () -> {
                    ingredientService.getById(foundId);
                });
                assertEquals("찾는 재료가 없습니다. id=" + foundId, exception.getMessage());
                assertThrows(IllegalArgumentException.class, () -> ingredientService.getById(foundId));
            }
        }
    }

    @Nested
    @DisplayName("Describe: getAll Method")
    class Describe_getAll{
        @BeforeEach
        void prepare() {
            ingredientRepository.deleteAll();
        }

        @Nested
        @DisplayName("Context: with void")
        class Context_with_Void {
            final IngredientDto givenDto1 = IngredientDto.builder()
                    .name(name)
                    .storage(storage)
                    .shelfLife(shelfLife)
                    .type(type)
                    .build();

            final IngredientDto givenDto2 = IngredientDto.builder()
                    .name(name)
                    .storage(storage)
                    .shelfLife(shelfLife)
                    .type(type)
                    .build();

            @Test
            @DisplayName("It find a ingredient by id and return dto")
            void it_find_ingredient_by_id_return_dto() {

                final Long savedId1 = ingredientService.save(givenDto1);
                final Long savedId2 = ingredientService.save(givenDto2);
                List<IngredientDto> findList = ingredientService.getAll();

                assertEquals(findList.size(), 2);
            }
        }
    }
}
