package com.developpez.skillbrowser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.developpez.skillbrowser.model.Message;

@RestResource(path = "message")
public interface MessageRepo extends JpaRepository<Message, Integer> {
	
	@Query("select m from Message m where concat('', m.user) = :id")
	List<Message> findByUser(@Param(value = "id") String id);

}
