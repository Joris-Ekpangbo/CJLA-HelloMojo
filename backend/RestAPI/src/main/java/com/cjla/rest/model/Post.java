package com.cjla.rest.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.PROPERTY)
// @XmlType(propOrder = {"isbn", "author", "title", "categories"})
public class Post {

	private String id;
	private String owner;
	private String content;
	private String classId;
	private int likes;
	private ArrayList<String> tags;
	private ArrayList<Comment> comments;

	@XmlElement
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

//	public ArrayList<String> getComments() {
//		return comments;
//	}
//
//	public void setComments(ArrayList<String> comments) {
//		this.comments = comments;
//	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
