package com.yummy.domain.user;

import com.yummy.domain.ingredient.IngredientDto;
import com.yummy.domain.ingredient.model.Ingredient;
import com.yummy.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public UserDto getById(Long id){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 재료가 없습니다. id=" + id));

        return new UserDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAll(){
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("찾는 재료가 없습니다. id=" + id));

        user.update(userDto);
        return id;
    }

    public void delete(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 재료가 없습니다. id=" + id));

        userRepository.delete(user);
    }

}
