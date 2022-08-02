package com.yummy.domain.user.model;

import com.yummy.domain.ingredient.IngredientDto;
import com.yummy.domain.user.UserDto;
import com.yummy.global.model.BaseTimeEntity;
import com.yummy.global.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String picture;
//    @Column
//    Role role;

    public void update(UserDto userDto){
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.picture = userDto.getPicture();
    }
}
