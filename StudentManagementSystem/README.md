# Student Management System

## Description

This project is a Student Management System developed in Java. It uses the Spring Framework for creating RESTful APIs and Hibernate for handling database operations. The project is built and managed with Maven.  The system is designed to handle operations related to Teachers, Quizzes, and Courses. Each entity has its own controller which provides endpoints for creating, retrieving, updating, and deleting instances of the respective entity.  

The `StudentController` provides endpoints for managing `Student` entity. It allows you to create a new Student, retrieve a Student by their ID, update a Student's details, and delete a Student by their ID.

The `TeacherController` provides endpoints for managing `Teacher` entity. It allows you to create a new teacher, retrieve a teacher by their ID, update a teacher's details, and delete a teacher by their ID.  

The `QuizController` provides endpoints for managing `Quiz` entity. It allows you to create a new quiz, retrieve a quiz by its ID, update a quiz's details, and delete a quiz by its ID.  

The `CourseController` provides endpoints for managing `Course` entity. It allows you to create a new course, retrieve a course by its ID, update a course's details, and delete a course by its ID.

The project uses the Jackson library for serializing and deserializing Java objects to and from JSON, which is the data format used for the HTTP requests and responses. The project also uses the JSR-310 date/time types, and it includes the jackson-datatype-jsr310 module to enable Jackson to handle these types.
## Features

- CRUD operations for `Student`, `Teacher`, `Quiz`, and `Course` entities.

## Installation

1. Clone the repository: git clone https://github.com/AhmedElsayed23/StudentManagementSystem.git
2. Navigate to the project directory: cd StudentManagementSystem
3. Build the project using Maven: mvn clean install

## Usage

1. Start the application: mvn spring-boot:run
2. The application will be accessible at `http://localhost:8080`.

## API Endpoints

- 'POST /students/add': Create a new student.
- `GET /students/get/{id}`: Retrieve a student by ID.
- `PUT /students/update`: Update a student.
- `DELETE /students/delete/{id}`: Delete a student by ID.
- `POST /teachers/add`: Create a new teacher.
- `GET /teachers/get/{id}`: Retrieve a teacher by ID.
- `PUT /teachers/update`: Update a teacher.
- `DELETE /teachers/delete/{id}`: Delete a teacher by ID.
- `POST /quizzes/add`: Create a new quiz.
- `GET /quizzes/get/{id}`: Retrieve a quiz by ID.
- `PUT /quizzes/update`: Update a quiz.
- `DELETE /quizzes/delete/{id}`: Delete a quiz by ID.
- `POST /courses/add`: Create a new course.
- `GET /courses/get/{id}`: Retrieve a course by ID.
- `PUT /courses/update`: Update a course.
- `DELETE /courses/delete/{id}`: Delete a course by ID.

## Database

The `studentManagementSystemDB.mwb` file in the project directory is a MySQL Workbench data model for the database used in this project. You can open this file using MySQL Workbench to view the database schema.

## Dependencies

- Java 21
- Spring Framework
- Hibernate
- Maven
- Jackson

## To-Do

- Implement the relationship between `Student` and `Course` entities.
- Implement the relationship between `Teacher` and `Course` entities.
- Implement the relationship between `Student` and `Quiz` entities.
- Implement the relationship between `Teacher` and `Quiz` entities.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)