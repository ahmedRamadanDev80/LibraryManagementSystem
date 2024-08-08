# Library Management System

This is a Spring Boot application designed to manage a library system, handling operations related to books, patrons, and borrowing records.

## Entities

The application consists of three primary entities:

1. **Book**: Represents the books available in the library.
2. **Patron**: Represents the patrons (users) who can borrow books.
3. **BorrowingRecord**: Tracks the borrowing and return of books by patrons.

## API Endpoints

### Book Management Endpoints

These endpoints allow you to perform CRUD (Create, Read, Update, Delete) operations on books in the library.

- **GET /api/books**: Retrieve a list of all books.
  
  Example Response:
  ```json
  [
    {
      "id": 1,
      "title": "Book Title",
      "author": "Author Name",
      "publicationYear": 2020,
      "isbn": "123-4567890123"
    }
    
  ]
  ```

- **GET /api/books/{id}**: Retrieve details of a specific book by ID.

  Example Response:
  ```json
  {
    "id": 1,
    "title": "Book Title",
    "author": "Author Name",
    "publicationYear": 2020,
    "isbn": "123-4567890123"
  }
  ```

- **POST /api/books**: Add a new book to the library.

  Example Request:
  ```json
  {
    "title": "New Book",
    "author": "Author Name",
    "publicationYear": 2024,
    "isbn": "987-6543210987"
  }
  ```

- **PUT /api/books/{id}**: Update an existing book's information.

  Example Request:
  ```json
  {
    "title": "Updated Book Title",
    "author": "Updated Author Name",
    "publicationYear": 2021,
    "isbn": "123-4567890123"
  }
  ```

- **DELETE /api/books/{id}**: Remove a book from the library.

### Patron Management Endpoints

These endpoints allow you to perform CRUD operations on patrons.

- **GET /api/patrons**: Retrieve a list of all patrons.

  Example Response:
  ```json
  [
    {
      "id": 1,
      "name": "Patron Name",
      "contactInfo": "+123456789"
    }
  ]
  ```

- **GET /api/patrons/{id}**: Retrieve details of a specific patron by ID.

  Example Response:
  ```json
  {
    "id": 1,
    "name": "Patron Name",
    "contactInfo": "+123456789"
  }
  ```

- **POST /api/patrons**: Add a new patron to the system.

  Example Request:
  ```json
  {
    "name": "New Patron",
    "contactInfo": "+987654321"
  }
  ```

- **PUT /api/patrons/{id}**: Update an existing patron's information.

  Example Request:
  ```json
  {
    "name": "Updated Patron Name",
    "contactInfo": "+123456789"
  }
  ```

- **DELETE /api/patrons/{id}**: Remove a patron from the system.

### Borrowing Record Endpoints

These endpoints manage the borrowing and returning of books by patrons.

- **POST /api/borrow/{bookId}/patron/{patronId}**: Allow a patron to borrow a book.

  

- **PUT /api/return/{bookId}/patron/{patronId}**: Record the return of a borrowed book by a patron.


## Database Configuration

Before running the application, ensure that you have PostgreSQL installed and running on your system. You need to create a database named `LibraryMS` in PostgreSQL.

### Steps to Create the Database

1. Open your PostgreSQL command-line interface (CLI) or use a PostgreSQL management tool like pgAdmin.
2. Run the following SQL command to create the database:

   ```sql
   CREATE DATABASE LibraryMS;
   ```

3. Ensure that the application properties are correctly configured with your PostgreSQL credentials.

### Example Configuration

Update the `application.properties` file with the following configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/LibraryMS
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Replace `your_username` and `your_password` with your PostgreSQL username and password.

  
## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/library-management-system.git
   ```
2. Import the Project:
   - If you haven't already opened the project, select File > Open... and navigate to the root directory of the project (library-management-system). Select the pom.xml file and click Open. IntelliJ IDEA will import the Maven project.

3. Configure the Application:
   - Once the project is imported, IntelliJ should automatically detect it as a Maven project and configure it accordingly.
   - In the Project Explorer, locate the src/main/java directory and right-click on the main class (the class annotated with @SpringBootApplication). This is usually located in the com.task.library_management_system package.

4. Run the Application:

    - Right-click on the main class and select Run 'YourMainClass'. IntelliJ IDEA will build and start the Spring Boot application.
    - You can also use the run/debug configuration options by clicking on the run/debug configuration dropdown in the top-right corner of IntelliJ IDEA. Click Edit Configurations..., create a new Spring Boot configuration if necessary, and set it up to point to the main class. Then you can run the application using the green play button.

5. The application will be available at `http://localhost:8080`.

6. You can use the endpoints with postman or run the unit tests.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **Spring Boot Starter Web**: To build web applications, including RESTful services.
- **Spring Boot Starter Data JPA**: For ORM with Hibernate and Spring Data JPA.
- **Jakarta Validation**: For input validation in DTOs.
- **Hibernate Validator**: Implements Jakarta Validation for ensuring data integrity.
- **Spring Security Test**: Provides tools to test security configurations.
- **Spring Boot Starter Test**: Includes testing libraries like JUnit and Mockito.
- **Spring Boot Starter Tomcat**: Embedded Tomcat server to run the application.
- **PostgreSQL**: Database for persistent storage.

