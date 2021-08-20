package com.til.newswebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PriorityList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer PriorityListId;

    private String description;

    private String name;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "priorityList")
    private List<PriorityArticles> priorityArticlesList = new ArrayList<>();

    public void addPriorityArticles(PriorityArticles priorityArticles){
        priorityArticlesList.add(priorityArticles);
        priorityArticles.setPriorityList(this);
    }
}
