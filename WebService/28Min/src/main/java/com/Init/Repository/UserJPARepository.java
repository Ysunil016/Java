package com.Init.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Init.Bean.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer> {

}
