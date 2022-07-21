package com.yummy.domain.userstorage;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class UserStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long foodId;
    FoodType foodType;
    LocalDateTime bestBeforeDate;
    LocalDateTime deletedDate;
}
