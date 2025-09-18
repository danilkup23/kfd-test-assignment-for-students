# KFD Test Assignment -- Solution
You can read project requirements in *README_TASK.MD* file.
## Description
The library management console application written by Java without frameworks. 
You can manage library data like books, users and records of borrowed books.
## Application's architecture
This application based on architecure's pattern MVC (Model -- View -- Controller).
### Model
Model was presented by *model* package which includes business entites: **Book**, **Entry** and **User** (Student, Faculty and Guest).
### View
The *view* is presented by *view* package. This application's layer is responsible for rendering menu and accepting user input.
### Controller
The *contoller* is presented by *controller* package. This application's layer is responsible for accepting requests from users to interact with data.
### DAO
This layer of application is responsible for execute SQL-requests to database.
The *SQLite* is used to manage the database. 
### DTO
This layer is responsible for transfer DAO-objects to specified entities for output in console.
## Version
*Alpha 1.0* with some bugs and unrealized features.
## Author's information
Balakovo Engineering and Technological Institute, a branch of the National Research Nuclear University MEPhI, student-programmer, III course.
 
 

