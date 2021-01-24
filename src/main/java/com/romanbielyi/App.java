package com.romanbielyi;

import com.romanbielyi.dao.impls.AuthorDao;
import com.romanbielyi.dao.impls.BookDao;
import com.romanbielyi.dao.impls.UserDao;
import com.romanbielyi.dao.interfaces.CRUD;
import com.romanbielyi.entities.Author;
import com.romanbielyi.entities.Book;
import com.romanbielyi.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        CRUD<Author> authorDao = context.getBean(AuthorDao.class);
        CRUD<Book> bookDao = context.getBean(BookDao.class);
        CRUD<User> userDao = context.getBean(UserDao.class);


        Author authorJKRowling = context.getBean(Author.class);
        Book bookHarryPotter = context.getBean(Book.class);
        User userSteven = context.getBean(User.class);

        bookHarryPotter.setName("Harry Potter and the Philosopher's Stone");
        List<Author> authorList = new ArrayList<>();

        authorJKRowling.setName("J. K. Rowling");
        authorDao.save(authorJKRowling);
        authorList.add(authorJKRowling);
        bookHarryPotter.setAuthorList(authorList);
        bookDao.save(bookHarryPotter);

        userSteven.setName("Steven Yablonsky");
        userDao.save(userSteven);
        List<Book> bookList = new ArrayList<>();
        bookList.add(bookHarryPotter);
        authorJKRowling.setBookList(bookList);
        authorDao.update(authorJKRowling);
        userSteven.setBookList(bookList);
        userDao.update(userSteven);

        userDao.findAll().forEach(System.out::println);
    }
}
