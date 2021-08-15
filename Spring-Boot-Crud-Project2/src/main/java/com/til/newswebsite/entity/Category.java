package com.til.newswebsite.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="CATEGORY_TBL")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String categoryName;
	
	private String description;
	
	private Date createdAt;
	
	private Date modifiedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Category(Integer id, String categoryName, String description, Date createdAt, Date modifiedAt) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public Category() {
		super();
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", description=" + description + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + "]";
	}
	
	
}
