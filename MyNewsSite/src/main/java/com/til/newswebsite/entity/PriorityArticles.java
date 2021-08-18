package com.til.newswebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PriorityArticles {
    @Id
    private Integer PriorityArticlesId;

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
