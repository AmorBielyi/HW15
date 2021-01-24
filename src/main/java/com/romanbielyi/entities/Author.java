package com.romanbielyi.entities;

import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Table(name = "authors")
@Proxy(lazy = false)
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books;

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBooks() {
        StringBuilder b = new StringBuilder();
        for (Book book : books) {
            b.append(book.getName()).append("; ");
        }
        return b.toString();
    }

    public void setBookList(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBookList() {
        return books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name ='" + name + "}";
    }
}
