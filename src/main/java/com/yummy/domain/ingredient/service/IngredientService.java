package com.yummy.domain.ingredient.service;

import com.yummy.domain.ingredient.IngredientDto;
import com.yummy.domain.ingredient.Ingredient;
import com.yummy.domain.ingredient.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Transactional
    public Long save(IngredientDto ingredientDto){
        return ingredientRepository.save(ingredientDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public IngredientDto getById(Long id){
        Ingredient ingredient = ingredientRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 재료가 없습니다. id=" + id));

        return new IngredientDto(ingredient);
    }

    @Transactional(readOnly = true)
    public List<IngredientDto> getAll(){
        return ingredientRepository.findAll().stream()
                .map(IngredientDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("찾는 재료가 없습니다. id=" + id));

        ingredient.update(ingredientDto);
        return id;
    }

    public void delete(Long id){
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 재료가 없습니다. id=" + id));

        ingredientRepository.delete(ingredient);
    }
}
