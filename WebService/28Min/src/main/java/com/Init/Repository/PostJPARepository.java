package com.Init.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Init.Bean.Post;

@Repository
public interface PostJPARepository extends JpaRepository<Post, Integer> {

}
