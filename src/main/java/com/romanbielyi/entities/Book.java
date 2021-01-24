package com.romanbielyi.entities;

import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Table(name = "books")
@Proxy(lazy = false)
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "title")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_user",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private User user;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<Author> getAuthorList() {
        return authors;
    }

    public void setAuthorList(List<Author> authors) {
        this.authors = authors;
    }

    public String getAuthors() {
        StringBuilder b = new StringBuilder();
        for (Author author : authors) {
            b.append(author.getBooks()).append("; ");
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title = '" + name + "'" +
                ", authors = " + authors + "}";
    }
}
