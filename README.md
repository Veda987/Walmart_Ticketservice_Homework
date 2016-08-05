# Walmart_Ticketservice_Homework

Wal-Mart Ticket Service application Installing and Running instructions
==================================================

1. Please Download the Ticket Service homework code from github repository link below
   https://github.com/Veda987/Walmart_Ticketservice_Homework.git
2. Assuming JAVA_HOME and M2_HOME environment variables set, go to code downloaded directory.
3. On command line run the command "mvn package". This will build the "Walmart_Veda_Ticketservice-1.0-SNAPSHOT.jar".
4. Then to launch the application run the command "java -jar target/Walmart_Veda_Ticketservice-1.0-SNAPSHOT.jar"
5. Above command should launch the application with options as shown below.

***************** Welcome To Wal-Mart Ticket Service *****************

********************************************************************
Customer Menu Options to Proceed through [Check Available Seats/Holding Seats/Reservation/Exit]: 

[1] for Available Seats
   Enter [1] to View Available Seats in Orchestra
   Enter [2] to View Available Seats in Main
   Enter [3] to View Available Seats in Balcony1
   Enter [4] to View Available Seats in Balcony2
   Enter [5] to View Available Seats in All Levels.
[2] for Holding Seats
   Enter No of Seats to Hold :
   Enter Minimum Level :
   Enter Maximum Level :
   Enter Customer Email :
[3] for Reservation, 
   Enter Your Seat Hold ID :
   Enter Customer Email :
[4] for Exit
********************************************************************

Assumptions
********************************************************************
1. Venue Details [Levels, Rows & Seats] are Configurable in ticketservice.properties file. Details can be Added or Changed before Each Run.

3. In Each Level, Rows are named as A, B, C....Z, AA, AB....AAA.....So On, and Seats are named as (RowID + Unique Sequence Number) on Each Level.

4. As part of Seat Holding, If Customer Providers Min and Max Level then, Program finds and Hold Seats based on Availability on any Level. Priority Goes from Min to Max Levels.

2. Ticket's Temporary Hold time is configured to 1 Minute. If Customer does not proceed for Reservation with in 1 Minute then, Temporary Hold will be expired and No longer the Customers can proceed for Reservation.

5. For Reservation, Seat Hold ID are Customers Emails are REQUIRED to Input by Customer.

6. Up on, Successful Reservation the Program Prints Confirmation No as : (T-SeatHold ID)

7. Booking Details are not saved either in Database or in File System. For each Application Run, New Venue, Levels, Rows, Seats, Orders get created.
********************************************************************

