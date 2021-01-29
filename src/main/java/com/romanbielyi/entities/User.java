package com.romanbielyi.entities;

import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Table(name = "users")
@Proxy(lazy = false)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books;


    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBookList() {
        return books;
    }

    public void setBookList(List<Book> books) {
        this.books = books;
    }

    public String getBooks() {
        StringBuilder b = new StringBuilder();
        for (Book book : books) {
            b.append(book.getName()).append("; ");
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "name = '" + name + "'" +
                ", books = " + books + "}";
    }
}
