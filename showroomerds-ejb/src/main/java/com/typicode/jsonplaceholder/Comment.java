package com.typicode.jsonplaceholder;

import java.util.Date;


public class Comment extends Interaction {
	private int commentId;
    private Date date;
    private String text;
    
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comment(int interactionId, int userId, int productId,User users, Product products) {
		super(interactionId, userId, productId, users, products);
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId, Date date, String text) {
		super();
		this.commentId = commentId;
		this.date = date;
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", date=" + date + ", text=" + text + ", toString()="
				+ super.toString() + "]";
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
    
}
