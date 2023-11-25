# 🗃 Blog API
#### by Ren Ramos

a blog web service that provide REST API endpoints built in Java, Spring Boot, Spring Data JDBC and MySQL.
This web app is to demonstrate Spring Boot and Spring Data JDBC capabilities to implement a back-end solution. This web app uses Maven as build tool.

#### Configurations
1. First you must have MySQL Server installed to your local machine. After installation, you have the option to install also the MySQL Workbench as User Interface.
2.  Next configure the __"application.properties"__ file from src/main/resources, to match your MySQL server credentials application.properties file:
```
spring.datasource.url=jdbc:mysql://localhost:3306/[your database name]
spring.datasource.username=root
spring.datasource.password=[your mysql user password. blank is default]
spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:blogAccountsSchema.sql,classpath:blogsSchema.sql
```
3. Then run the class **"SpringBootBlogRestApiApplication.java"** which has the main method.
4. Then use postman or any REST client you want to test this web application. Thank you so much. Please use the sample requests I provided.

###### Please follow these for best experience:
1. Create your first blog account, by using the "Sign up for new blog account" POST request. 
2. Then create your first blog through the "Create Blog" POST request.
                    **The aforementioned requests can be found in the sample requests below**


### Sample Requests
#### GET Request for all blogs
- View all blogs written by the users
```
http://localhost:8080/blogs
```
#### GET Request for all of your blogs
- View all your blogs
```
http://localhost:8080/myBlogs
```
#### GET Log out
- Log out your account.
```
http://localhost:8080/logout
```
#### POST Log in Blog account
- Login to your signed in account. When the user is logged in, the API will generate new session object
```
http://localhost:8080/login
Body(JSON)
{
    "email": "test@email.com",
    "password": "password12345"
}
```
#### POST Sign up for new blog account
- Create a blogging account. This will store the information to the database and the password will also be hashed by BCrypt libarary.
```
http://localhost:8080/signup
Body(JSON)
{
	"firstName": "John",
    "lastName": "Doe",
    "email": "testing@email.com",
    "password":"password12345"
}
```
#### POST Create Blog
- Create a blog. You should be first logged in before you can interact with this REST end-point.
```
http://localhost:8080/create-blog
Body(JSON)
{
    "blogTitle":"Data Structures and Algorithms problem solving practice.",
    "blogContent":"You need to become proficient in data structures and algorithms...",
    "dateCreated":"2023-11-24"
}
```
#### PUT Edit Blog
- Update your created blog. You should be first logged in before you can interact with this REST end-point.
```
http://localhost:8080/edit-blog
Body(JSON)
{
    "blogID":1,
    "blogTitle":"The Noah's Ark",
    "blogContent":"Once upon a time..."
}
```
#### DELETE Delete Blog
- Delete your existing blog by its ID. We suppose the user-interface will let you select your blogs through cards and when clicked it will store the Blog ID, and then when you choose the delete option, it will store the ID as a request parameter. You should be first logged in before you can interact with this REST end-point.
```
http://localhost:8080/delete-blog?id=1
QUERY PARAMS 
key = id 
value = 1
```


