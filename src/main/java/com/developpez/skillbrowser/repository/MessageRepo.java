package com.developpez.skillbrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.developpez.skillbrowser.model.Message;

@RestResource(path = "message")
public interface MessageRepo extends JpaRepository<Message, Integer> {

}
