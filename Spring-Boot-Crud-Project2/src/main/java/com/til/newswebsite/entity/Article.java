package com.til.newswebsite.entity;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Article_TBL")
public class Article {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int quantity;
	private double price;
	

}
