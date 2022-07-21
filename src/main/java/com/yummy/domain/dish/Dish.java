package com.yummy.domain.dish;

import com.yummy.domain.food.Food;

import javax.persistence.Entity;

@Entity
public class Dish extends Food {

    DishType type;

}
