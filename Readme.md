# Iampod Application
This App is  used for testing deployment using Kubernetes (K8s), Jenkins,  Docker...
This Spring Boot application has two Endpoints :
1. Restfull api Endpoint:
   - Endpoint: `/api`
   - Functionality: Provides information about the operating system, host IP, and current CPU load. This information can be accessed through appropriate API calls.

2. Static Website Serving:
   - Endpoint: `/`
   - Functionality: Serves a static website. Users can access the website by navigating to the root URL. The website might contain various HTML, CSS, and JavaScript files, along with other assets, necessary for the website's functionality and appearance.

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
   or
   ```sh
   mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8080
   ```
5. The application will start and be accessible at [http://localhost:8080/](http://localhost:8080/).

6. You can also get the response from the terminal using curl 
   ```bash
   curl -s http://localhost:8080/api | jq
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
