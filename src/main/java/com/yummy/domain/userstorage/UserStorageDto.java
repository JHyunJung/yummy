package com.yummy.domain.userstorage;

import com.yummy.domain.ingredient.model.FoodType;
import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.ingredient.model.Storage;
import com.yummy.domain.userstorage.model.AmountType;
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
    Long id;
    Long userId;
    Long foodId;
    FoodType foodType;
    Storage storageType;
    AmountType amountType;
    FreshnessType freshnessType;
    LocalDateTime bestBeforeDate;
    LocalDateTime deletedDate;

    public UserStorageDto(UserStorage userStorage){
        this.id = userStorage.getId();
        this.userId = userStorage.getUserId();
        this.foodId = userStorage.getFoodId();
        this.foodType = userStorage.getFoodType();
        this.storageType = userStorage.getStorageType();
        this.amountType = userStorage.getAmountType();
        this.freshnessType = userStorage.getFreshnessType();
        this.bestBeforeDate = userStorage.getBestBeforeDate();
        this.deletedDate = userStorage.getDeletedDate();
    }

    public UserStorage toEntity(){
        return UserStorage.builder()
                .id(id)
                .userId(userId)
                .foodId(foodId)
                .foodType(foodType)
                .storageType(storageType)
                .amountType(amountType)
                .freshnessType(freshnessType)
                .bestBeforeDate(bestBeforeDate)
                .deletedDate(deletedDate)
                .build();
    }

}
