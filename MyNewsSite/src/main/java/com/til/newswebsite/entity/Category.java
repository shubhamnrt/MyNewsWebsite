package com.til.newswebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="CATEGORY_TBL")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String categoryName;

    private String description;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date modifiedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Article> articleList = new ArrayList<Article>(0);


    public void addArticle(Article article){
        articleList.add(article);
        article.setCategory(this);
    }

}
