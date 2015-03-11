# prime-service
Author(s): Neelabh Agrawal
e-mail(s): nagrawa1@binghamton.edu

PURPOSE:

[
  Program with a simple multi-threaded client-server code in Java. Learned to apply the design 
  principle "Program to interface and not to implementation". Learned to implement Singleton 
  Design Pattern. 
  The program runs server and client. Multiple clients can connect to a server. A client can
  send a query to find if a number is prime. Server sends response to client and save client
  requests in a data structure. A menu is displayed at server and client to make interaction
  with user.
]

TO COMPILE:

[
  Just extract the files and then run following command in primeService directory
  ant -buildfile src/build.xml all

]

TO RUN:

[
  Please run below command from directory where this README is present
  For server - 
  ant -buildfile src/build.xml run -Darg0=server -Darg1=<port number> -Darg2=<debug value>

  For client -
  ant -buildfile src/build.xml run -Darg0=client -Darg1=<hostname> -Darg2=<port number>
   -Darg3=<debug value>

  Debug value should be between 0 to 3 for dubug purpose as below -
  
  3 [Print to log file everytime a method other than a constructor is called.]
  
  2 [Print to log file everytime a constructr is called]
  
  1 [Print to log file everytime query is stored in server data structure.]
  
  0 [No output will be printed]
  

]

FILES:

[
  Included with this project are 16 files:

  build.xml, ant file to compile and run 
  PrimeDriver.java, the main file associated with program also contains main
  
  ServerDriver.java, file which contains class to run server
  
  ClientDriver.java, file which contains class to run client
  
  AllPrimeQueries.java, file which contains class for storing client queries
  
  PrimeQueriesInterface.java, file which contains interface implemented by 
		AllPrimeQueries class
		
  PrimeMenu.java, file which contains interface implemented by ClientMenu and 
		ServerMenu class
		
  ClientMenu.java, file which contains class to display client menu and take 
		user input
		
  ServerMenu.java, file which contains class to display server menu and take 
		user input
		
  CheckPrime.java, file which contains class to process client query
  
  CheckPrimeInterface.java, file contains interface implemented by CheckPrime
  
  PrimeServerSocket.java, file which contains class to create server socket and 
		accept client connection
		
  PrimeServerWorker.java, file which contains class to communicate with client
  
  PrimeClientSocket.java, file which contains class to create client socket and
		communicate with server
		
  Debug.java, file responsile for printing Debug messages in log file
  
  README.txt, the text file you are presently reading
  
]

SAMPLE OUTPUT:

[

---------Server Side----------

neelabh@ubuntu:$ ant -buildfile src/build.xml run -Darg0=server -Darg1=56777 -Darg2=3

Buildfile: /home/neelabh/cs542/assignment2/agrawal_neelabh_assign1/primeService/src/build.xml


jar:

    [mkdir] Created dir: /home/neelabh/cs542/assignment2/agrawal_neelabh_assign1/primeService/BUILD/jar
    
      [jar] Building jar: /home/neelabh/cs542/assignment2/agrawal_neelabh_assign1/primeService/BUILD/jar/primeService.jar

run:

     [java] [1] Client Name
     
     [java] [2] All client queries
     
     [java] [3] Quit
     
1 test

     [java] test : 1 4 
     
     [java] [1] Client Name
     
     [java] [2] All client queries
     
     [java] [3] Quit
     
2

     [java] test : 1 4 
     
     [java] [1] Client Name
     
     [java] [2] All client queries
     
     [java] [3] Quit
     
3


BUILD SUCCESSFUL

Total time: 1 minute 10 seconds


---------Client Side----------

neelabh@ubuntu:$ ant -buildfile src/build.xml run -Darg0=client -Darg1=localhost -Darg2=56777 -Darg3=3

Buildfile: /home/neelabh/cs542/assignment2/agrawal_neelabh_assign1/primeService/src/build.xml


jar:

run:

     [java] [1] Set Client Name
     
     [java] [2] Enter number to query for prime
     
     [java] [3] What is the server response?
     
     [java] [4] Quit
     
1 test

     [java] [1] Set Client Name
     
     [java] [2] Enter number to query for prime
     
     [java] [3] What is the server response?
     
     [java] [4] Quit
     
2 1

     [java] [1] Set Client Name
     
     [java] [2] Enter number to query for prime
     
     [java] [3] What is the server response?
     
     [java] [4] Quit
     
3

     [java] Can't say
     
     [java] [1] Set Client Name
     
     [java] [2] Enter number to query for prime
     
     [java] [3] What is the server response?
     
     [java] [4] Quit
     
2 4

     [java] [1] Set Client Name
     
     [java] [2] Enter number to query for prime
     
     [java] [3] What is the server response?
     
     [java] [4] Quit
     
3

     [java] Yes
     
     [java] [1] Set Client Name
     
     [java] [2] Enter number to query for prime
     
     [java] [3] What is the server response?
     
     [java] [4] Quit
     
4



BUILD SUCCESSFUL

Total time: 1 minute 55 seconds

]

BIBLIOGRAPHY:

[
  * http://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
  * http://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServer.java
  * http://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServerThread.java
]

