package com.til.newswebsite.entity;

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
public class PriorityArticles {
    @Id
    private Integer PriorityArticlesId;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToMany
    @JoinColumn
    private List<Article> articleList = new ArrayList<>();

    public void addArticle(Article article){
        articleList.add(article);
        article.getPriorityArticlesList().add(this);
    }

    @ManyToMany
    private List<PriorityList> priorityListList = new ArrayList<>();

    public void addPriorityList(PriorityList priorityList){
        priorityListList.add(priorityList);
        priorityList.getPriorityArticlesList().add(this);
    }




}
