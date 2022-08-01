package com.yummy.domain.user;

import com.yummy.domain.ingredient.model.Storage;
import com.yummy.domain.user.model.User;
import com.yummy.domain.userstorage.model.AmountType;
import com.yummy.domain.userstorage.model.FreshnessType;
import com.yummy.domain.userstorage.model.UserStorage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String picture;

    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .picture(picture)
                .build();
    }
}
