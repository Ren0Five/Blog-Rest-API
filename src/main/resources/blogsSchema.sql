create table if not exists Blogs(
      blogID int not null primary key,
      blogTitle varchar(255) not null,
      blogContent text not null,
      blogImage varchar(255) not null,
      blogAuthor varchar(255) not null,
      datePublished date not null
);
