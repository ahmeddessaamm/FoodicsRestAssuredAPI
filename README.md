# Foodics RestAssured API

This project demonstrates API testing using RestAssured for the Foodics API. The framework is designed to ensure modularity, scalability, and easy maintenance of API test cases.

## Features
- **Framework**: Built using RestAssured and TestNG.
- **Automation**: Covers API scenarios such as user creation, retrieval, and updates.
- **Error Handling**: Includes robust error handling for invalid requests, unexpected responses, and network issues.
- **Reporting**: Integrates with Allure Report for detailed test reports.

## Prerequisites
- **Java**: Version 8 or higher installed. [Download Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven**: Installed and configured in your system. [Download Maven](https://maven.apache.org/download.cgi)
- **TestNG**: Included as a dependency in your Maven project. No separate installation needed; it will be downloaded automatically when you run Maven.
- **Maven**: Installed and configured in your system. [Download Maven](https://maven.apache.org/download.cgi)

- **Git**: Installed and authenticated with your GitHub account. [Install Git](https://git-scm.com/)

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   ├── pojo/                  # POJO classes for request and response
│   │   └── restAssured/           # Core framework files
│   └── resources/
│       └── config.properties      # Configuration file
├── test/
│   └── java/
│       └── testPackage/           # Test classes
```

## How to Set Up
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ahmeddessaamm/FoodicsRestAssuredAPI.git
   ```
   Navigate to the project directory:
   ```bash
   cd FoodicsRestAssuredAPI
   ```

2. **Import Project**:
   - Open IntelliJ IDEA.
   - Select "File > Open" and navigate to the cloned repository.

3. **Install Dependencies**:
   Run the following Maven command to download dependencies:
   ```bash
   mvn clean install
   ```

4. **Configure the Project**:
   - Open `src/main/resources/config.properties`.
   - Update the `baseURI`, `name`, and `job` values as needed.

5. **Run Tests**:
   - To execute tests, run:
     ```bash
     mvn test
     ```
   - Alternatively, right-click on the test class in IntelliJ and select "Run".

## Example API Scenarios
1. **Create User**: Sends a `POST` request to `/api/users` with the user's name and job.
2. **Retrieve User**: Sends a `GET` request to `/api/users/{id}` to fetch user details.
3. **Update User**: Sends a `PUT` request to `/api/users/{id}` with updated details.

## Contributing
Feel free to contribute to the project by submitting issues or creating pull requests.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
