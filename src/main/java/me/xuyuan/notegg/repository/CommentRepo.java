package me.xuyuan.notegg.repository;

import me.xuyuan.notegg.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.repository.annotation.RestResource;


@RestResource(path = "comment")
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
