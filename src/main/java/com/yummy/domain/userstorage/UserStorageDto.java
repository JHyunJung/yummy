package com.yummy.domain.userstorage;

import com.yummy.domain.ingredient.model.FoodType;
import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserStorageDto {

    Long userId;
    Long foodId;
    FoodType foodType;
    LocalDateTime bestBeforeDate;
    LocalDateTime deletedDate;

    public UserStorageDto(UserStorage userStorage){
        this.userId = userStorage.getUserId();
        this.foodId = userStorage.getFoodId();
        this.foodType = userStorage.getFoodType();
        this.bestBeforeDate = userStorage.getBestBeforeDate();
        this.deletedDate = userStorage.getDeletedDate();
    }
}
