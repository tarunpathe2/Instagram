package com.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.model.Tags;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {

}
