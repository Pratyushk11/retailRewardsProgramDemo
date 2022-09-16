# retailRewardsProgramDemo
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.   
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction


#Steps for Running the Application :

1)Right click on pointGenerator.java and run as Java application. 

2)Once the springBoot application is started. See the port number from the console. (Tomcat started on port:8090 (http))

3)open a browser and type http://localhost:8090/pointGenerated/customers/{customerId} in the url.

example: http://localhost:8090/pointGenerated/customers/3 in the url.

4) It will print a JSON response based on the {customerId} entered(1,2,3,4) at the end of the url. 

example response : {"customerId":3,"lastMonthPoints":1048.0,"lastSecondMonthPoints":72.0,"lastThirdMonthPoints":49.0,"totalPoints":1169.0}


#Additional Info about the Application :

1)If there are more than one transaction in a month all the points of that month will be added and displayed in that particular months response. 

2)If a requested custmerId is not available in the data set. than it will return "No Transaction found for this customer Id"

example: http://localhost:8090/pointGenerated/customers/10
response: No Transaction found for this customer Id


