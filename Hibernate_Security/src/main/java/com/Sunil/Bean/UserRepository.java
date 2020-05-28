package com.Sunil.Bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.Sunil.Bean.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String> {

}
