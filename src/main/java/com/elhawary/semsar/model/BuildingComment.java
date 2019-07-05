package com.elhawary.semsar.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class BuildingComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;

	@Column(columnDefinition = "TEXT")
	private String commentCotents;

	private int commentStarts;

	@Lob
	@Basic(fetch = FetchType.EAGER)
	private byte[] commentPhoto;

	private long commentCount = 0;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingsId")
	private Buildings buildings;

	@ManyToOne
	private User user;

	@Column(columnDefinition = "DATETIME")
	private Date commentDate;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommentCotents() {
		return commentCotents;
	}

	public void setCommentCotents(String commentCotents) {
		this.commentCotents = commentCotents;
	}

	public int getCommentStarts() {
		return commentStarts;
	}

	public void setCommentStarts(int commentStarts) {
		this.commentStarts = commentStarts;
	}

	public byte[] getCommentPhoto() {
		return commentPhoto;
	}

	public void setCommentPhoto(byte[] commentPhoto) {
		this.commentPhoto = commentPhoto;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public Buildings getBuildings() {
		return buildings;
	}

	public void setBuildings(Buildings buildings) {
		this.buildings = buildings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
}
