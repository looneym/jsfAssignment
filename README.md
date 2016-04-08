**Cans4Cash - Example e-commerce site using the JavaEE Stack**
==========================================================

Project description
-------------------

The site allows for the manual input of products which can be displayed to a user for purchase. Users can add items to a cart and checkout at which point an order is created and saved. 

Products are stored as JPA entities and added to a Cart as Cart Item entities, themselves containing a Product object. This is repeated again for Order objects. 

Objects are written as Java Beans using private variables and getter/setter methods. 

JSF is used for the presentation layer to allow easy integration with values through the Java Bean specification.

Spring handles the service and persistence layers, interacting with the database using Hibernate. 

Planned additions
-----------------
Development is ongoing as this is a project for my diploma in software dev.

The application will interface with the Amazon product API to pull products. Full user authentication/authorization will be implemented as well as more complex admin functionality. 

Full list of technologies used
------------------------------

 - Primefaces 
 - JSF (Java Server Faces) 
 - Spring 
 - JPA 
 - JavaBeans 
 - MySQL

