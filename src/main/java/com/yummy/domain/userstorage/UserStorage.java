package com.yummy.domain.userstorage;

import com.yummy.domain.ingredient.model.FoodType;
import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.user.User;
import com.yummy.global.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @Column
    Long userId;

//    @ManyToOne(targetEntity = Ingredient.class, fetch=FetchType.LAZY)
    @Column
    Long foodId;

    @Enumerated(EnumType.STRING)
    @Column
    FoodType foodType;

    @Column(nullable = false)
    LocalDateTime bestBeforeDate;

    @Column
    LocalDateTime deletedDate;



}
