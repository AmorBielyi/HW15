create table if not exists users(
    user_id serial primary key,
    name varchar(80) not null
);

create table if not exists books(
    book_id serial primary key,
    title varchar(80) not null
);

create table if not exists authors(
    author_id serial primary key,
    name varchar(80) not null
);

create table if not exists book_author(
    book_author_id serial primary key,
    book_id int not null,
    foreign key (book_id) references books (book_id),
    author_id int not null,
    foreign key (author_id) references authors (author_id)
);

create table if not exists book_user(
    book_user_id serial primary key,
    book_id int not null,
    foreign key (book_id) references books (book_id),
    user_id int not null,
    foreign key (user_id) references users (user_id)
);

insert into books(title) values
('IT - horror novel by Stephen King'),
('Lord of the Rings - Phantasy Adventure by J. Reuel Tolkien');

insert into users(name) values
('John Kasper');

insert into authors(name) values
('Stephen King'),
('John Ronald Reuel Tolkien');

insert into book_author(book_id, author_id) values
(1,1),
(2,2);

insert into book_user(book_id, user_id) values
(1,1),
(2,1);