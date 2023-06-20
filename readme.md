
# Mega Project - reshoprio
This is a prototype of an online marketplace. The system meets many of the functional requirements that was specified in the assignment. 
- A user can declare a product to sell and add information about it.
- A user can search for products that are available on the marketplace.
- A user can add products to a shopping cart and then confirm the cart as an order.
- A user can register an interest in a particular product type.
## Architecture
- **Microservices**
    - CartsService
    - OrderService
    - ProductService
    - SearchService
    - UserService
    - AutchenticationService
    - Utils
- **Client-Server**
    - ServerDiscovery
    - GatewayApplication
- **Publish-Subscribe**
    - SubscribtionService
    - NotificationService
## Technologies Used
**Front-End:** 
- SvelteKit & Vite
- TailwindCSS

**Back-End:** 
- Java Spring Boot
    - Eureka Server
    - Spring Cloud Gateway
- Firebase Real-Time Database 
## Run Locally
- Make sure you have [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) installed on your machine.
- Make sure you have [Maven](https://maven.apache.org/download.cgi) installed on your machine.
- Make sure you have [Node.js](https://nodejs.org/en/download) installed on your machine. (version 16 or later)
- Clone the repository to your local machine. 
### Back-end
- Navigate to folder: back-end/mini-project
- Open the folder in IntelliJ
- Execute [Maven goals](https://www.jetbrains.com/help/idea/work-with-maven-goals.html):
    - mvn clean
    - mvn compile   
- Run the back-end:
    - Start ServerDiscovery
    - Start GatewayApplication
    - Start the remaining services
### Front-End
- Navigate to folder: front-end/src
- Install the dependencies from your terminal:
```bash
npm install
```
- Run the front-end
```bash
npm run dev
``` 
## Authors
- Habib Mohammadi   - [@khabbib](https://github.com/khabbib)
- Kasper Kadestål   - [@Kasperkadestal](https://github.com/Kasperkadestal)
- Jakob Hagman      - [@JSGHagman](https://github.com/JSGHagman)
- Sossio Giorgelli  - [@SossioG](https://github.com/SossioG)
- Philip Holmqvist  - [@PhilipHolmqvist](https://github.com/PhilipHolmqvist)



