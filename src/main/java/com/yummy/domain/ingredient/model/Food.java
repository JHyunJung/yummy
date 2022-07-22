package com.yummy.domain.ingredient.model;

import com.yummy.global.model.BaseTimeEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@SuperBuilder
@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class Food extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Storage storage;

    @Column
    protected int shelfLife;



}
