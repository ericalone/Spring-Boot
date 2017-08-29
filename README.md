# Spring-Boot

1. REST service includes a REST controller -- StudentController exposes two service methods, one to get a specific student and one to return all students information. There is a unit test for this controller.

In the unit test

    Mock out the StudentService using Mockito
    Use Mock MVC framework to launch only StudentController.

URL:
    http://localhost:8080/students
    http://localhost:8080/students/student1

2. MVC applicatin includes a controller -- WelcomeController renders a simple welcome page:

    http://localhost:8080

3. Start server
   git clone https://github.com/ericalone/Spring-Boot.git
   mvn spring-boot:run

4. Run test
   mvn test
