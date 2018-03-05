package com.cjla.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Comment {
	@XmlRootElement(name = "comment")
	@XmlAccessorType(XmlAccessType.PROPERTY)
	// @XmlType(propOrder = {"isbn", "author", "title", "categories"})
	public class Post {

		private String user;
		private String message;
		private String dateCreated;
		private int likes;
		
		@XmlElement
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		@XmlElement
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@XmlElement
		public String getDateCreated() {
			return dateCreated;
		}
		public void setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
		}
		@XmlElement
		public int getLikes() {
			return likes;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		
	}
}
