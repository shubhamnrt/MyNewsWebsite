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

<<<<<<< HEAD
    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
=======
    @Column(unique = true)
    private String email;

    @Column(unique = true)
>>>>>>> 22bbefa1821f939cd69ea7611e56e10ed75bf1a1
    private String userName;

    private String fullName;

    private String password;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "author")
    private List<Article> articleList = new ArrayList<Article>(0);

    public void addArticle(Article article){
        articleList.add(article);
        article.setAuthor(this);
    }

}
