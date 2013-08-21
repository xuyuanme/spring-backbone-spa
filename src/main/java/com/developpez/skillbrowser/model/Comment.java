package com.developpez.skillbrowser.model;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@Entity
@DiscriminatorValue("2")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class Comment extends BaseMessage {
	public Comment() {
		super();
		this.setText("default comment");
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentMessage")
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
