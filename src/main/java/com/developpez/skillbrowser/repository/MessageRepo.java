package com.developpez.skillbrowser.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.developpez.skillbrowser.model.Message;
import com.developpez.skillbrowser.model.User;
import com.developpez.skillbrowser.model.dto.MessageDto;

@RestResource(path = "message")
public interface MessageRepo extends JpaRepository<Message, Integer> {
	
	//@Query("select m from Message m where concat('', m.user) = :id")
	List<Message> findByUser(@Param(value = "id") User user);
	
	@Query("select new com.developpez.skillbrowser.model.dto.MessageDto"
			+ " (m.id,u.login,m.text,m.timestamp) "
			+ " from Message m, User u "
			+ " where m.user = u.id "
			)
	Page<MessageDto> findAllDto(Pageable pageable);

}
