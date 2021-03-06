# Expense Reimbursement System (ERS) - Java

## Project Description -    
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used -    
Servlets, Java, JavaScript, HTML, CSS, JDBC

## Features
 * Sign up as either an employee or manager
 * Login as either an employee or manager  
 
    Employee features:
    * View past & current reimbursement tickets
    * Add reimbursement requests  
    
    Manager features:
    * View all reimbursement tickets submitted from all employees
    * Approve or deny reimbursement requests

## Getting Started
(include git clone command) (include all environment setup steps)
1. Git clone project 1.
2. Navigate to src > main > java > daoHouse > ConnectionHoose.java and insert database credentials under: 
* public static String url = "jdbc:postgresql://""/Project_1";
*	public static String username = "";
*	public static String password = "";
3. Create a Apache Tomcat server.
4. Start the server.
5. Run the index.html.
