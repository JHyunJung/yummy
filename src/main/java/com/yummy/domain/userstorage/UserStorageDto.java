package com.yummy.domain.userstorage;

import com.yummy.domain.ingredient.model.FoodType;
import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.userstorage.model.FreshnessType;
import com.yummy.domain.userstorage.model.UserStorage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserStorageDto {

    Long userId;
    Long foodId;
    FoodType foodType;

    FreshnessType freshnessType;
    LocalDateTime bestBeforeDate;
    LocalDateTime deletedDate;

    public UserStorageDto(UserStorage userStorage){
        this.userId = userStorage.getUserId();
        this.foodId = userStorage.getFoodId();
        this.foodType = userStorage.getFoodType();
        this.freshnessType = userStorage.getFreshnessType();
        this.bestBeforeDate = userStorage.getBestBeforeDate();
        this.deletedDate = userStorage.getDeletedDate();
    }

    public UserStorage toEntity(){
        return UserStorage.builder()
                .userId(userId)
                .foodId(foodId)
                .foodType(foodType)
                .freshnessType(freshnessType)
                .bestBeforeDate(bestBeforeDate)
                .deletedDate(deletedDate)
                .build();
    }

}
