package com.developpez.skillbrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.developpez.skillbrowser.model.Comment;

@RestResource(path = "comment")
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
