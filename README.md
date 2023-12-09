# Employee and Machine Management

## Objective

This project aims to develop a web application for managing employees and machines using Spring Boot, Maven, Thymeleaf, and Chart.js. The main goal is to demonstrate the use of these technologies to create a CRUD (Create, Read, Update, Delete) application with machine filtering by employee and the display of statistical charts.

## Technologies Used

- **Spring Boot**: Java framework for web application development.
- **Maven**: Project management and build tool.
- **Thymeleaf**: Template engine for web page creation.
- **Chart.js**: JavaScript library for interactive chart creation.
- **Spring Security**: Security module for user authentication.
- **MySQL**: Relational database management system.

## Features

The application provides the following features:

- **Employee Management**: Add, delete, update, and list employees.
- **Machine Management**: Add, delete, update, and list machines.
- **Machine Filtering by Employee**: Ability to filter the list of machines by employee.
- **Chart of Number of Machines Purchased per Year**: Use Chart.js to illustrate the number of machines purchased each year.
- **Chart of Number of Machines per Employee**: Use Chart.js to illustrate the number of machines assigned to each employee.
- **Authentication**: Users must authenticate as administrators to access management features.

## Project Structure

The project will be organized as follows:

- 📁**`src/main/java`**: Contains the Java classes of the project.
- 📄**`src/main/resources`**: Resources necessary for the project, such as configuration files.
- 🌐**`src/main/resources/templates`**: Contains HTML pages with Thymeleaf.
- 📊**`src/main/resources/static`**: Contains static files such as CSS stylesheets and JavaScript scripts.
- 🧪**`src/test`**: Directory for unit tests.

## Illustrations
### Conception
<img width="420" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/57b181e7-6fe5-4c6f-9944-31a49d347756">


### Authentication Page
<img width="635" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/b805c8ac-5e25-4c75-86f3-d3a0d27897ec">

#### invalid credentials
<img width="593" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/b5364547-93b8-43dd-bc43-76559f236d89">

<img width="633" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/c8852495-e360-4889-b883-a06c6cd7ff2a">

#### valid credentials ---> home page
<img width="627" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/994b900f-a77d-46cf-8323-3b6b7747c45c">

<img width="895" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/dafbafcf-a017-4351-a03e-fdf0c814e091">



### Employe managment
<img width="950" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/134d189e-88ba-42ba-a224-227b74767a24">

#### Edit employe
<img width="960" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/5b6115a2-5f4a-4ddb-a1eb-e4df64a0825f">
<img width="960" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/1e4aa13f-9bba-4a28-b871-2f6a7dcdc2c2">

#### Add employe
<img width="608" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/450b1722-b53d-44c4-b810-4f75ef8070d7">
<img width="464" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/1cf00922-9966-4635-a669-d70e9511f845">
<img width="633" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/84e0813e-3ddb-4492-9f2b-10266bc4ef28">


#### Delete employe
<img width="960" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/97c02fd9-5328-4a82-81c3-4ababdd9b91c">
<img width="960" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/ea9fe40c-f3f5-4ee0-b14c-ff0d86399d60">


### Machine Management

<img width="960" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/a87c0dfd-e7db-4e3e-a49f-71b386a6857f">


#### Add machine
<img width="383" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/f7a3c158-9f5a-4bd0-abf7-0a18bd4faa05">
<img width="697" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/16672d40-bdc8-442b-82bf-474abbdea2d6">



#### Delete machine
<img width="960" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/97999963-214d-48f9-bd41-d47f6e1f6c97">
<img width="960" alt="image" src="https://github.com/killer-beep07/employees-and-machines-management-Thymleaf/assets/130712993/58a5fc57-a90a-45a6-9e11-105288f13f37">

### Sort By Date

<img width="891" alt="image" src="https://github.com/killer-beep07/employees-and-machines-management-Thymleaf/assets/130712993/b053ed6b-e52d-47a6-90a8-20019c2d36a5">
<img width="875" alt="image" src="https://github.com/killer-beep07/employees-and-machines-management-Thymleaf/assets/130712993/a47e4b67-3991-4b3b-b517-0a1fb15cfadc">


### Filtering
<img width="953" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/19241057-cc7a-499f-aa64-c496692add3e">

<img width="950" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/f071314b-343b-4347-9b7c-fe1534550826">


### A chart illustrating machines acquired by year
<img width="837" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/1e1972d0-5a01-4e45-b223-a83795c6e16b">

### A chart illustrating machines acquired by employee
<img width="723" alt="image" src="https://github.com/killer-beep07/ll/assets/130712993/36695536-9bf6-45c6-98fd-5cd80cbaca46">

## How to Run the Project

1. Ensure you have Java and Maven installed.
2. Configure the MySQL database with the necessary access information.
3. Modify the Spring configuration file (`application.properties`) with the database details.
4. Launch the application using the Maven command: `mvn spring-boot:run`.
