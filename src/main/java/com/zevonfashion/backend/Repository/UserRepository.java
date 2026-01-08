package com.zevonfashion.backend.Repository;

import com.zevonfashion.backend.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
