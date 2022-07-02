package com.santosh.main.model;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
public class BookVO {
	@Id
	private String id;
	private String title;
	private Binary image;
	private String author;
	private Date dateOfPublication;
	private List<String> chapters;
	private int	price;
	private String couponCode;
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDateOfPublication() {
		return dateOfPublication;
	}
	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}
	public List<String> getChapters() {
		return chapters;
	}
	public void setChapters(List<String> chapters) {
		this.chapters = chapters;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVO [id=" + id + ", title=" + title + ", image=" + image + ", author=" + author
				+ ", dateOfPublication=" + dateOfPublication + ", chapters=" + chapters + ", price=" + price
				+ ", couponCode=" + couponCode + "]";
	}
}
