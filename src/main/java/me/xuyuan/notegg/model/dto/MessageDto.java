package me.xuyuan.notegg.model.dto;

import java.util.Date;

import me.xuyuan.notegg.model.Message;
import me.xuyuan.notegg.model.User;


public class MessageDto {
	public MessageDto(Message m, User u) {
		setId(m.getId());
		setUserId(u.getId());
		setUser(u.getLogin());
		setText(m.getText());
		setTimestamp(m.getTimestamp());
	}

	public MessageDto(Integer id, User u, String user, String text, Date timestamp) {
		setId(id);
		setUserId(u.getId());
		setUser(user);
		setText(text);
		setTimestamp(timestamp);
	}

	Integer id;
	Integer userId;
	String user;
	String text;
	Date timestamp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
