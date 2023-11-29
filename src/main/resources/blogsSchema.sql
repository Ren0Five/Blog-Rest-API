create table if not exists Blogs(
      blogID int not null auto_increment primary key,
      blogTitle varchar(255) not null,
      blogContent text not null,
      blogAuthor varchar(255) not null,
      datePublished date not null
);
