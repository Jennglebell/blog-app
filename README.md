# Spring Boot Blog REST API

A comprehensive Spring Boot blog application with REST APIs, built for learning and demonstrating modern web development practices. This application provides a complete blogging platform with user authentication, post management, comments, categories, and more.

## Features

- 🔐 **User Authentication & Authorization** - JWT-based authentication with role-based access control
- 📝 **Post Management** - Create, read, update, and delete blog posts
- 💬 **Comment System** - Users can comment on blog posts
- 🏷️ **Categories** - Organize posts by categories
- 🛍️ **Product Management** - Additional product functionality
- 📚 **API Documentation** - Interactive Swagger/OpenAPI documentation
- 🔒 **Security** - Spring Security integration with JWT tokens
- 🗄️ **Database Integration** - MySQL database with JPA/Hibernate
- ✅ **Validation** - Input validation for all API endpoints
- 🌍 **Multi-Environment Support** - Development, QA, and Production profiles

## Technologies Used

- **Java 17**
- **Spring Boot 3.0.0**
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database operations
- **MySQL** - Database
- **JWT (JSON Web Tokens)** - Authentication tokens
- **Swagger/OpenAPI 3** - API documentation
- **ModelMapper** - Object mapping
- **Lombok** - Reduce boilerplate code
- **Maven** - Dependency management and build tool

## Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+**
- **MySQL 8.0+**
- **Git**

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Jennglebell/blog-app.git
cd blog-app
```

### 2. Database Setup

1. Create a MySQL database named `myblog`
2. Update the database configuration in [`src/main/resources/application-dev.properties`](src/main/resources/application-dev.properties):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/myblog
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Build and Run

```bash
# Build the application
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, you can access the interactive API documentation at:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## Project Structure

```
src/
├── main/
│   ├── java/com/springboot/blog/
│   │   ├── controller/          # REST controllers
│   │   ├── service/             # Business logic
│   │   ├── repository/          # Data access layer
│   │   ├── entity/              # JPA entities
│   │   ├── dto/                 # Data transfer objects
│   │   ├── config/              # Configuration classes
│   │   ├── security/            # Security configuration
│   │   └── exception/           # Exception handling
│   └── resources/
│       ├── application.properties           # Main configuration
│       ├── application-dev.properties       # Development profile
│       ├── application-qa.properties        # QA profile
│       └── application-prod.properties      # Production profile
└── test/                        # Unit and integration tests
```

## Environment Profiles

The application supports multiple environment profiles:

- **Development** (`dev`) - For local development
- **QA** (`qa`) - For testing environment  
- **Production** (`prod`) - For production deployment

To run with a specific profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## API Endpoints

### Authentication
- `POST /api/v1/auth/signin` - User login
- `POST /api/v1/auth/signup` - User registration

### Posts
- `GET /api/v1/posts` - Get all posts
- `GET /api/v1/posts/{id}` - Get post by ID
- `POST /api/v1/posts` - Create new post
- `PUT /api/v1/posts/{id}` - Update post
- `DELETE /api/v1/posts/{id}` - Delete post

### Comments
- `GET /api/v1/posts/{postId}/comments` - Get comments for a post
- `POST /api/v1/posts/{postId}/comments` - Add comment to post
- `PUT /api/v1/posts/{postId}/comments/{id}` - Update comment
- `DELETE /api/v1/posts/{postId}/comments/{id}` - Delete comment

### Categories
- `GET /api/v1/categories` - Get all categories
- `POST /api/v1/categories` - Create category
- `PUT /api/v1/categories/{id}` - Update category
- `DELETE /api/v1/categories/{id}` - Delete category

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](https://github.com/Jennglebell/license) file for details.

## Contact

**Jennifer** - [gwyjennifer@gmail.com](mailto:gwyjennifer@gmail.com)

Project Link: [https://github.com/Jennglebell/blog-app](https://github.com/Jennglebell/blog-app)

## Acknowledgments

- Spring Boot team for the excellent framework
- Spring Security for robust authentication
- Swagger/OpenAPI for API documentation
- MySQL for reliable database support
