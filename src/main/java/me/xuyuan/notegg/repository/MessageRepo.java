package me.xuyuan.notegg.repository;

import java.util.List;

import me.xuyuan.notegg.model.Message;
import me.xuyuan.notegg.model.User;
import me.xuyuan.notegg.model.dto.MessageDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;


@RestResource(path = "message")
public interface MessageRepo extends JpaRepository<Message, Integer> {
	
	//@Query("select m from Message m where concat('', m.user) = :id")
	List<Message> findByUser(@Param(value = "id") User user);
	
	@Query("select new me.xuyuan.notegg.model.dto.MessageDto"
			+ " (m.id,u.fullname,m.text,m.timestamp) "
			+ " from Message m, User u "
			+ " where m.user = u.id "
			)
	Page<MessageDto> findAllDto(Pageable pageable);

}
