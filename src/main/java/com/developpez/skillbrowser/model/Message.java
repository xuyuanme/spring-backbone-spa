package com.developpez.skillbrowser.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@Entity
@DiscriminatorValue("1")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = Inclusion.NON_NULL)
public class Message extends BaseMessage {
	public Message() {
		super();
		this.setText("default message");
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "message")
	private Set<Comment> comments = new HashSet<Comment>(0);

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Comment> getComments() {
		return comments;
	}
}
