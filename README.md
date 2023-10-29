# FoodItem Delivery
 * This project is a Java and Spring Boot based FoodItem Delivery API. The project utilizes the MVC (Model-View-Controller) architecture to ensure that the code is modular and easily readable. The foodItem Delivery Api has Three models, the FoodItem and user,and order and their respective permissions to perform CRUD (Create, Read, Update, Delete) .
 
 ## Screenshots
![Screenshot 2023-10-29 083125](https://github.com/Shravankumar542-d/assignment/assets/142691051/66bc8560-d437-4b70-82ae-11039de805ac)

![Screenshot 2023-10-29 083006](https://github.com/Shravankumar542-d/assignment/assets/142691051/e05d1f29-a3c5-424b-8d88-7c8cbb0c40ab)

 ![Screenshot 2023-10-29 083436](https://github.com/Shravankumar542-d/assignment/assets/142691051/2190220f-4751-4258-8689-45be6368bcea)229968238-e65bf4c9-b11f-457b-a2c6-af3dd7cadd87.png)
 
 ![Screenshot 2023-10-29 083823](https://github.com/Shravankumar542-d/assignment/assets/142691051/e6612460-f761-4eb2-afe8-13a1e23f3e73)
 
 ![Beige Minimalist Mood Photo Collage (2)](https://user-images.githubusercontent.com/111841729/229969636-9bf2a2d1-64e4-4fd7-b9f5-999bd79e72e1.png)


# Technologies Used
 The following technologies were used to build thisFoodItem Delivery Api:
* Spring Boot
* Java
* MySQL database/SQL

# Project Flow

* Controller
The request comes from the client-side and hits the controller class, which then processes the request based on the request type and endpoints declared in the controller class's methods using annotations. The methods of the service class are called from the controller class.


* Service
The service class contains the main business logic for the music streaming system. The methods of the service class are called from the controller class, where we use in-built or native queries of the repository interface.

* Repository
The repository is an interface that extends the JPAREPOSITORY interface, and we used the methods of JPAREPOSITORY and native queries/queries by the method, which we write in the repository interface.

* Database
With the help of Hibernate, we were able to connect to the database. For this project, we used a MySQL database.

# Data Structure Used in Project
* The project mainly uses ArrayList.

# Request and Endpoint URLs
Here are the request and endpoint URLs for the FoodItemDelivery APi:

* Swagger Deployment URL

You can access the Swagger documentation for this API at the following URL:

http://65.2.94.104:8080/swagger-ui.html

* Endpoints

Here are the endpoints available in this API:

* Admin

Create Admin: swagger /saveAdmin


Login Admin: POST /loginAdmin And Normal User.

* FoodItem
Save fooditem: POST /FoodItem/Add

Get Fooditem: GET /getFood

Update foodtItem: PUT /Update

Delete fooditem: DELETE /delete

* User

Create User: POST /singup


Login User: POST /singin

* order

Place order: POST /place/order

Get Order: GET /history


# Project Summary
In summary, this project is a foodIten delivery Api that allows two types of users, the fooditem and the user, to perform CRUD operations on songs and playlists. The project uses the MVC architecture to make the code modular and readable. It utilizes various technologies such as Spring Boot, Java, and MySQL database/SQL to provide an efficient and effective FoodItem
Delivery Api.






