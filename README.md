# Uppvit API
![GitHub top language](https://img.shields.io/github/languages/top/prathamesh-a/uppvit-api)
![GitHub issues](https://img.shields.io/github/issues/prathamesh-a/uppvit-api)
![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/prathamesh-a/uppvit-api?include_prereleases)
![GitHub last commit](https://img.shields.io/github/last-commit/prathamesh-a/uppvit-api)


## Overview
Uppvit is a social media network that allows users to create guilds (communities) 
and write posts in guilds.
Users can create guilds for their topics of interest and have endless discussions.
Users can share text posts and links to content in the post. Posts can be upvoted or downvoted by other users.
This repository represents the RESTful API for the Uppvit client developed in Spring Boot.

#### Documentation: https://prathamesh-a.github.io/uppvit-api/

## Developer Setup
### System Requirements
- Java 8+
- MySQL Server
- POSTMAN (for testing)

### Setting up local environment
1. Download the source code and initiate the maven project in your IDE.
2. Update the credentials for MySQL Server and SMTP Server in `src/main/resources/application.properties`.
3. Update the database schema name in `application.properties` for the field `spring.datasource.url`.
4. Update the `springblog.jks` file with your own keystore data.
5. Run the server on your local machine.
6. You may now make API calls to the server locally via `localhost:8080`, the API documentation can also be accessed at http://localhost:8080/swagger-ui.html#/.

## Diagrams
### Database Schema
![image](https://user-images.githubusercontent.com/89336149/192137125-1b789430-f6a0-481d-8689-10bf6b4da320.png)
### Class Diagram
![inix](https://user-images.githubusercontent.com/89336149/192227158-9ece3acd-d467-4acc-916f-8be3630faef7.png)


## Features
- ### User Authentication
  User authentication is secured by JSON Web Tokens, each token expires/is refreshed after 15 minutes. Each provided email is verified before activation of the user account. All the routes except documentation are secured and cannot be accessed without a valid token.
- ### Guilds
  Guilds are the boards/communities created by users for different topics of interest. Users can have discussions in the guild on topics relative to the guild. Users are allowed to write posts in multiple guilds.
- ### Posting
  Once authenticated, a user can write the post in any of the available guilds. Users can include links to the websites, videos, and images while writing the post. A user is allowed to send multiple posts in a guild.
- ### Voting
  Other users can give a vote on your post by giving you an upvote or downvote. One user is allowed to vote once per post.
- ### Comments
  You can comment on your own as well as others' posts. Anyone who can see the post is allowed to write comments on the post.

### Dependencies Used
[ Map Struct, Spring Boot Jpa, Java Mail Sender, Spring Security, Lombok, MySQL Connector, JSON Web Tokens, Time Ago, Kotlin STDLIB, Thymeleaf ]



## Uppvit Client
The client for this API is still under development. It will be released once it is done.
