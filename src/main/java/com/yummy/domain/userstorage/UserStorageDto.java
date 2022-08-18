package com.yummy.domain.userstorage;

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
    private Long id;
    private Long userId;
    private Long ingredientId;
    private Storage storageType;
    private AmountType amountType;
    private FreshnessType freshnessType;
    private LocalDateTime bestBeforeDate;
    private LocalDateTime deletedDate;

    public UserStorageDto(UserStorage userStorage){
        this.id = userStorage.getId();
//        this.user = userStorage.getUser();
//        this.ingredientId = userStorage.getIngredient();
        this.storageType = userStorage.getStorageType();
        this.amountType = userStorage.getAmountType();
        this.freshnessType = userStorage.getFreshnessType();
        this.bestBeforeDate = userStorage.getBestBeforeDate();
        this.deletedDate = userStorage.getDeletedDate();
    }

    public UserStorage toEntity(){
        return UserStorage.builder()
                .id(id)
//                .userId(userId)
//                .ingredientId(ingredientId)
                .storageType(storageType)
                .amountType(amountType)
                .freshnessType(freshnessType)
                .bestBeforeDate(bestBeforeDate)
                .deletedDate(deletedDate)
                .build();
    }

}
