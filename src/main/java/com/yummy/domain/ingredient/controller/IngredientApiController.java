package com.yummy.domain.ingredient.controller;

import com.yummy.domain.ingredient.IngredientDto;
import com.yummy.domain.ingredient.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IngredientApiController {

    private final IngredientService ingredientService;

    @PostMapping("/api/v1/ingredient")
    public Long save(@RequestBody IngredientDto ingredientDto){
        return ingredientService.save(ingredientDto);
    }

    @GetMapping("/api/v1/ingredient/{id}")
    public IngredientDto getById(@PathVariable Long id){
        return ingredientService.getById(id);
    }

    @GetMapping("/api/v1/ingredient/list")
    public List<IngredientDto> getAll() {
        return ingredientService.getAll();
    }

    @PutMapping("/api/v1/ingredient/{id}")
    public Long update(@PathVariable Long id, @RequestBody IngredientDto ingredientDto){
        return ingredientService.update(id, ingredientDto);
    }

    @DeleteMapping("/api/v1/ingredient/{id}")
    public Long delete(@PathVariable Long id){
        ingredientService.delete(id);
        return id;
    }
}
