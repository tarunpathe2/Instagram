package com.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.model.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes , Long>{

	public Long countByPostId(Long id);
}
