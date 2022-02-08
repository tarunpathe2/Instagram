package com.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.model.Follower;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long>{

}
