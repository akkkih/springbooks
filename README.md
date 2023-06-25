# SpringBooks
SpringBooks was created as a way to learn Spring and MongoDB. It's a simple project that provides a RESTful API for managing books. The project is built using Java and utilizes the Spring framework. It uses MongoDB as the database provider.

## Clone the Repository

To clone the repository, follow these steps:

1. Open a terminal or command prompt.
2. Change the current working directory to the location where you want to clone the repository.
3. Run the following command:

   ```shell
   git clone https://github.com/akkkih/springbooks.git
   ```

## Configure the Application Properties

Before running the code, you need to configure the `src/main/resources/application.properties` file to connect to your MongoDB instance. Follow these steps:

1. Open the `src/main/resources/application.properties` file.
2. Update the following properties with your MongoDB connection details:

   ```properties
   spring.data.mongodb.uri=<mongodb_uri>
   spring.data.mongodb.database=<mongodb_database>
   ```

   Replace `<mongodb_uri>`, and `<mongodb_database>` with your MongoDB server's URI and the desired database name, respectively.

3. Save the changes to the `application.properties` file.

## Accessing the Routes

The Spring project provides the following routes for managing books:

- `GET /api/v1/books`: Retrieves a list of all books.
- `GET /api/v1/books/{id}`: Retrieves a specific book by its ID.
- `POST /api/v1/books`: Creates a new book. The book details should be provided in the request body.
- `PUT /api/v1/books/{id}`: Updates an existing book with the specified ID. The updated book details should be provided in the request body.
- `DELETE /api/v1/books/{id}`: Deletes a book with the specified ID.

To interact with these routes, you can use tools like Insomnia. There's an [Insomnia configuration file](insomnia.json) for the environment on the root folder. Replace `{id}` in the route with the actual ID of the book you want to access.

## To-do List
- [ ] Add unit tests
- [ ] Add integration tests
- [ ] Add exception handling directly in the controller
- [ ] Add validation for the request body
- [ ] Rewrite code to Kotlin and optimize it

## Contributing
Feel free to contribute to this project. If you have any questions, feel free to contact me creating an issue or opening a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.