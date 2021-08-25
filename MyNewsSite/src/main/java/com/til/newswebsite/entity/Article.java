package com.til.newswebsite.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer articleId;

    @Column(unique=true,nullable=false)
    private String title;

    private String imageUrl;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @Lob
    private String description;

    @Lob
    private String content;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    private List<PriorityArticles> priorityArticlesList = new ArrayList<>();

    public void addPriorityArticles(PriorityArticles priorityArticles){
        priorityArticlesList.add(priorityArticles);
        priorityArticles.setArticle(this);
    }

}
