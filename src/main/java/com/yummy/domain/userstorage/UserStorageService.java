package com.yummy.domain.userstorage;

import com.yummy.domain.ingredient.IngredientDto;
import com.yummy.domain.ingredient.IngredientRepository;
import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.userstorage.model.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserStorageService {

    private final UserStorageRepository userStorageRepository;

    @Transactional
    public Long save(UserStorageDto userStorageDto){
        return userStorageRepository.save(userStorageDto.toEntity()).getId();
    }

//    @Transactional
//    public List<Long> saveAll(List<UserStorageDto> userStorageDtoList){
////        userStorageRepository.saveAll(userStorageDtoList);
////        return
//    }

    @Transactional(readOnly = true)
    public UserStorageDto getById(Long userId){
        UserStorage userStorage = userStorageRepository
                .findByUserIdAndDeletedDateNotNull(userId)
                .orElseThrow(() -> new IllegalArgumentException("찾는 재료가 없습니다. id=" + userId));

        return new UserStorageDto(userStorage);
    }

//    @Transactional(readOnly = true)
//    public List<UserStorageDto> getAllbyId(Long userId){
//        return userStorageRepository.findAllByUserIdAndDeletedDateIsNull(userId)
//                .stream()
//                .map(UserStorageDto::new)
//                .collect(Collectors.toList());
//    }

    @Transactional
    public Long update(Long userId, UserStorageDto ingredientDto) {
        UserStorage userStorage = userStorageRepository
                .findByUserIdAndDeletedDateNotNull(userId)
                .orElseThrow(()-> new IllegalArgumentException("찾는 재료가 없습니다. id=" + userId));

        userStorage.update(ingredientDto);
        return userId;
    }

    public void delete(Long id){
        UserStorage userStorage = userStorageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 재료가 없습니다. id=" + id));

        UserStorageDto userStorageDto = new UserStorageDto(userStorage);
        userStorageDto.setDeletedDate(LocalDateTime.now());

        userStorage.update(userStorageDto);
    }

    public void deleteList(List<Long> idList){
//        List<UserStorageDto> userStorageList = userStorageRepository.findAllByIdIn(idList);
//
//        userStorageList.stream()
//                .map(userStorageDto -> userStorageDto.setDeletedDate(LocalDateTime.now()))
    }

}
