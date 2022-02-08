package com.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instagram.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

}
