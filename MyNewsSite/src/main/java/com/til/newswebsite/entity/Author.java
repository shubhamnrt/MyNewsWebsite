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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer authorId;


    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String userName;

    //@Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "author")
    private List<Article> articleList = new ArrayList<>();

    public void addArticle(Article article){
        articleList.add(article);
        article.setAuthor(this);
    }

}
