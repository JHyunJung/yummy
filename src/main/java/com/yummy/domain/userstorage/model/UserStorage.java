package com.yummy.domain.userstorage.model;

import com.yummy.domain.ingredient.model.Storage;
import com.yummy.domain.userstorage.UserStorageDto;
import com.yummy.global.model.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@SuperBuilder
@Getter
@Entity
public class UserStorage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @OneToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @Column(updatable = false)
    Long userId;

//    @ManyToOne(targetEntity = Ingredient.class, fetch=FetchType.LAZY)
    @Column(updatable = false)
    Long ingredientId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Storage storageType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    AmountType amountType;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    FreshnessType freshnessType;

    @Column(nullable = false)
    LocalDateTime bestBeforeDate;

    @Column
    LocalDateTime deletedDate;

    public void update(UserStorageDto userStorageDto){
        this.freshnessType = userStorageDto.getFreshnessType();
        this.bestBeforeDate = userStorageDto.getBestBeforeDate();
        this.deletedDate = userStorageDto.getDeletedDate();
    }


}
