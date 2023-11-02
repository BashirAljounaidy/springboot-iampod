# Iampod Application

This Spring Boot application provides information about the operating system, host IP, and current CPU load.

![iampod](https://raw.githubusercontent.com/BashirAljounaidy/springboot-iampod/main/iampod-springboot.gif
)
## Prerequisites
- Java Development Kit (JDK) 17 or higher
- Maven

## Running the Application
To run the Iampod Application, follow these steps:

1. Clone the repository:

2. Navigate to the project directory:
   ```sh
   cd iampod
   ```

3. Build the project using Maven:
   ```sh
   mvn clean install
   ```

4. Run the application using Maven:
   ```sh
   mvn spring-boot:run
   ```

5. The application will start and be accessible at [http://localhost:8080/](http://localhost:8080/).

6. You can also get the response from the terminal using curl 
   ```bash
   curl -s http://localhost:8080 | jq
   ```

## Usage
- Access [http://localhost:8080/](http://localhost:8080/) in your web browser to view the system information provided by the application.
## Docker 

to build it 
```bash
cd springboot-iampod
docker build -t springboot-iampod .
```
```bash
docker run --rm --name iampod -p 8080:8080 springboot-iampod 
```
## Additional Notes
- Make sure no other application is using port 8080 before starting this application.
- This application fetches the operating system information, host IP, and current CPU load when accessed at the root URL.
- Customize the application as needed for your use case.

## License
This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).