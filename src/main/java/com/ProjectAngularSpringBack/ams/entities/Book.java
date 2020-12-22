 package com.ProjectAngularSpringBack.ams.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;



@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	//@NotBlank(message = "Title is mandatory")
	@Column(name = "title")
	private String title;
	//@NotBlank(message = "Author is mandatory")
	@Column(name = "author")
	private String author;
	//@NotBlank(message = "Price is mandatory")
	@Column(name = "price")
	private Double price;
	//@NotBlank(message = "quantity is mandatory")
	@Column(name = "quantity")
	private int quantity;
	//@NotBlank(message = "Date is mandatory")
	@Column(name = "date")
	private String releaseDate;
	
	
	
	public Book(long id, String title,String author,Double price,int quantity,String releaseDate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity=quantity;
		this.releaseDate = releaseDate;
		
	}
	
	

	public Book() {}
   
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	
}
