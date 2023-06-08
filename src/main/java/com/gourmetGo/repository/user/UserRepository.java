package com.gourmetGo.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface UserRepository<T> extends JpaRepository<T, UUID> {
    T findByUsername(String username);
}
