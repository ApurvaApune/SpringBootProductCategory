Prerequisites
Install Java 17 or higher.
Install Maven.
Install and set up MySQL.
Install a REST client (e.g., Postman ) for testing the APIs.

*****Steps to Run the Spring Boot API
     Create the Database
     In your MySQL server, create a database: 
     eg -   CREATE DATABASE product_management;

*****In application.properties add the database name you have created as your Database name , Your Username and password

*****Run the Application
     Use the following command to build and run the application:
*****Access the API
     The application will run at http://localhost:8080.
     If 8080 busy you can add new port as well. You can now use a REST client like Postman to test the API endpoints.

bash
Copy code
mvn spring-boot:run
1) Category CRUD operation.
    You can use Postman as client to hit this API's
1 http://localhost:8080/api/categories?page=3           GET all the categories
2 http://localhost:8080/api/categories                  POST - create a new category
3 http://localhost:8080/api/categories/{id}             GET category by Id
4 http://localhost:8080/api/categories/{id}             PUT - update category by id
5 http://localhost:8080/api/categories/{id}             DELETE - Delete category by id

2) PRODUCT CRUD operation 
1 http://localhost:8080/api/products?page=2            GET all the products
2 http://localhost:8080/api/products                   POST - create a new product
3 http://localhost:8080/api/products/{id}              GET product by Id
4 http://localhost:8080/api/products/{id}              PUT - update product by id
5 http://localhost:8080/api/products/{id}              DELETE - Delete product by id

***********Sample JSON Body for POST/PUT Categories:
json

Copy code
{
  "name": "Electronics"
}

**********Sample JSON Body for POST/PUT:
json

Copy code
{
  "name": "Laptop",
  "price": 1200.00,
  "category": {
    "id": 1
  }
}


Additional Information -
Pagination Support:
Both the category and product endpoints support pagination using the page query parameter. The default size is 10 items per page.

Error Handling:

If a category or product is not found the API will return a 404 Not Found status.
Invalid requests will return appropriate error codes such as 400 Bad Request.
Database Schema:
Categories Table:
Contains id (Primary Key) and name.
Products Table:
Contains id, name, price, and a foreign key category_id linking to the Categories table.
