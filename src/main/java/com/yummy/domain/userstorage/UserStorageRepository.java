package com.yummy.domain.userstorage;

import com.yummy.domain.ingredient.model.Storage;
import com.yummy.domain.userstorage.model.FreshnessType;
import com.yummy.domain.userstorage.model.UserStorage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserStorageRepository extends JpaRepository<UserStorage, Long> {

    Optional<UserStorage> findByUserIdAndDeletedDateNotNull(Long userId);
    List<UserStorageDto> findAllByUserIdAndDeletedDateIsNull(Long userId);
    List<UserStorageDto> findAllByUserIdAndStorageTypeAndDeletedDateIsNull(Long userId, Storage storageType);
//    List<UserStorageDto> findAllByUserIdAndStorageTypeAndFreshnessTypeAndDeletedDateIsNull(Long userId, Storage storageType, FreshnessType freshnessType);



}
