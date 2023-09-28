
# Java-Based-Taxi_Booking_Console_Application_with_mySQL-Backend

A java based console application for taxi booking using MySQL for backend connectivity. 

In this project a user gets to create their own account using phone number and password and can login using the same.
Each user must have unique phone number and it must be of 10 digits.
After the user gets logged in they will be redirected to  home menu where they can see their booking and wallet money options.
While booking a taxi the user must enter valid pickup location and destination location for the generated price of amount after which they can confirm their ride by choosing their mode of payment either by cash or using their wallet money.
If the user wishes to pay by cash 1% of their total amount will be added to their wallet, now that the bookings are confirmed and the balance amount in the wallet can be viewed on the console.
The user can also withdraw their wallet amount if they wish to pay the rest of the amount by cash. 
The user can check their wallet balance at anytime. 



## Technologies Used

- Java20
- MySQL
## Internal working of the Project

When executing the SQL file called projecttaxi (attached) two tables are created in the SQL database:
Table 1: To store user login data.
Table 2: To store user wallet amount.

Now when a user creates their account their login and wallet data gets stored in both the tables.
## Screenshots

### Creating Account:

![Creating Account](https://github.com/Prasanth2205/Java-Based-Taxi_Booking_Console_Application_with_mySQL-Backend/blob/main/ProjectTaxi/screenshots/Creating%20Account.png?raw=true)


### Login:
![Login](https://github.com/Prasanth2205/Java-Based-Taxi_Booking_Console_Application_with_mySQL-Backend/blob/main/ProjectTaxi/screenshots/Login.png?raw=true)

### User datas:

![User datas](https://github.com/Prasanth2205/Java-Based-Taxi_Booking_Console_Application_with_mySQL-Backend/blob/main/ProjectTaxi/screenshots/Taxi%20Table.png?raw=true)

### Taxi Wallet table:
![Wallet table](https://github.com/Prasanth2205/Java-Based-Taxi_Booking_Console_Application_with_mySQL-Backend/blob/main/ProjectTaxi/screenshots/Taxisavings%20table.png?raw=true)

### Booking Ride with cash:

![Booking ride with cash](https://github.com/Prasanth2205/Java-Based-Taxi_Booking_Console_Application_with_mySQL-Backend/blob/main/ProjectTaxi/screenshots/Booking%20Ride.png?raw=true)

### Booking ride with wallet money:

![Booking ride with Wallet money](https://github.com/Prasanth2205/Java-Based-Taxi_Booking_Console_Application_with_mySQL-Backend/blob/main/ProjectTaxi/screenshots/Booking%20ride%20with%20wallet%20money.png?raw=true)

### checking wallet balance:
![Checking wallet balance](https://github.com/Prasanth2205/Java-Based-Taxi_Booking_Console_Application_with_mySQL-Backend/blob/main/ProjectTaxi/screenshots/checking%20wallet%20balance.png?raw=true)
