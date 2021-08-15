package com.til.newswebsite.entity;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Article_TBL")
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true,nullable=false)
	private String title;
	
	@CreationTimestamp
	private Date createdAt;
	
	@CreationTimestamp
	private Date updatedAt;
	
	private String description;
	
	private String content;
	
	private String image;
	
	private boolean priority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public Article() {
		super();
	}

	public Article(Integer id, String title, Date createdAt, Date updatedAt, String description, String content,
			String image, boolean priority) {
		super();
		this.id = id;
		this.title = title;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.description = description;
		this.content = content;
		this.image = image;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", createdAt=" + createdAt + ", modifiedAt=" + updatedAt
				+ ", description=" + description + ", content=" + content + ", image=" + image + ", priority="
				+ priority + "]";
	}
	
	

}
