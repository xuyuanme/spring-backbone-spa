package com.developpez.skillbrowser.model.dto;

import java.util.Date;

import com.developpez.skillbrowser.model.Message;
import com.developpez.skillbrowser.model.User;

public class MessageDto {
	public MessageDto(Message m, User u) {
		setId(m.getId());
		setUser(u.getLogin());
		setText(m.getText());
		setTimestamp(m.getTimestamp());
	}

	public MessageDto(Integer id, String user, String text, Date timestamp) {
		setId(id);
		setUser(user);
		setText(text);
		setTimestamp(timestamp);
	}

	Integer id;
	String user;
	String text;
	Date timestamp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
