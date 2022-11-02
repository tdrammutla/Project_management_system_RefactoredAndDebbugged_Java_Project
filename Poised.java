/*
 *Project management system for a small structural engineering firm to keep track of the many projects on which they work
 * @author Tebogo Rammutla
 */

// Importing necessary classes from java core library
 import java.util.*;
import java.text.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

 /**
  * Poised Class
  */
public class Poised 

{ 
    //Properties of the class 
    private static Person person;
    private static Scanner scanner = new Scanner(System.in);
    private static int projectNo;
    private static File file = new File("./Completedproject.txt");
    private static Formatter formatter ;
    private static String projectFinalised = " is not finalised";
    private static String buildingType;
    private static String projectStatus = projectFinalised;
    private static String choice ;
    private static Project project;
    private static Poised poised;
      
    /**
     * Constructor of Poised Class
     * @param project the Project to set
     * @param person the person to set
     */
    public Poised(Project project,Person person)
    {
        // Properties of Poised class
        this.project = project;
        this.person=person;
    }
    
    /**
     * getProject
     * @return project object
     */
    public Project getProject()
    {   // returns Project object
        return this.project;  
    } 
    
    /**
     * getPerson
     * @return person object
     */ 
    public Person getPerson()
    {  
        return this.person;  
    } 
    
    /**
     * updateContractorDetails
     * @param contractor object to set
     */ 
    private static void  updateContractorDetails(Contractor contractor)
    {
            System.out.print("What would you like to change ?(telephone,email or both?) : ");
            String choice = scanner.next();
            if(choice.equalsIgnoreCase("telephone"))
                {
                    //Updating the contractor telephone details in contractor class                       
                    System.out.print("Please enter the contractor telephone number : ");
                    String telephoneNo = scanner.next();
                    contractor.setTelephoneNumber(telephoneNo); 
                }
            else if(choice.equalsIgnoreCase("email"))
                { 
                    //Updating the contractor email details in contractor class    
                    System.out.print("Please enter the contractor email address : ");
                    String emailAddress = scanner.next();
                    contractor.setEmailAddress(emailAddress); 
                }
            else if(choice.equalsIgnoreCase("both"))
                { 
                    //Updating the contractor contact details in contractor class                   
                    System.out.print("Please enter the contractor telephone number : ");
                    String telephoneNo = scanner.next();
                    contractor.setTelephoneNumber(telephoneNo);                    
                    System.out.print("Please enter the contractor email address : ");
                    String emailAddress = scanner.next();
                    contractor.setEmailAddress(emailAddress);                       
                }
    }
    
    /**
     * create Person
     * @return person object
     */ 
    private static Person createPersonObject()
    {
        Customer customer = new Customer("Tebogo","Rammutla","015 564 3456","tebza@hotmail.com","23 Vilakazi Street,Soweto,Johannesburg");
        Architect architect = new Architect("Jones","Makgoka","012 564 3456","jonesM@yahoo.com","34 Mole Street,Montana,Pretoria");
        Contractor contractor = new Contractor("Sara","Bartman","041 564 3456","sara.bartman@hotmail.com","11 Seapoint Street,Summerstrand,Port Elizaberth");
        Person person = new Person(customer,architect,contractor);
        return person;
    }
    
    /**
     * create Project 
     * @return project object
     */ 
    // Creating project object
    private static Project createProjectObject(String projectName,String buildingType,String physicalAddress,String erfNo, String projectTotalFee, String totalPaid,String projectDeadline)
    {
        projectNo ++;
        String projNo = "Project" + projectNo;
        Project project = new Project(projNo,projectName,buildingType,physicalAddress,erfNo,projectTotalFee,totalPaid,projectDeadline);   
        return project;
    }
    
    /**
     * Generating Customer Invoice method 
     * @param proNumber The project number to generate and invoice for
     * @param person The person object to get customer details
     */
    private static void  generatingInvoice(String proNumber,Person person)
    {
    	boolean flag = false;
    	int count = 0;
    	String pname;
    	String btype;
    	String paddress;
    	String erf;
    	String totFee;
    	String totpaid;
    	String dline;
    	String pstatus;
    	try
    		{
    			scanner = new Scanner(file)	;
    			while(scanner.hasNextLine()) 
    				{
    					String line = scanner.nextLine();
    					if(line.contains(proNumber)) 
    					{
    						flag = true;
    						pname = scanner.nextLine();
    						btype = scanner.nextLine();
    						paddress = scanner.nextLine();
    						erf = scanner.nextLine();
    						totFee = scanner.next();
    						String totFee1 = scanner.next();
    						String totFee2 = scanner.next();
    						String totFee3 = scanner.next();
    						String totFee4 = scanner.next();
    						String totFeeAmount = scanner.next();
    						totpaid = scanner.next();
    						String totpaid1 = scanner.next();
    						String totpaid2 = scanner.next();
    						String totpaid3 = scanner.next();
    						String totpaid4 = scanner.next();
    						String totpaid5 = scanner.next();
    						String totpaid6 = scanner.next();
    						String totpaidAmount = scanner.nextLine();
    						String deadline = scanner.nextLine();
    						String pstatus1 = scanner.nextLine(); 						
    				        String oldContent = "";
    					    BufferedReader reader = null;        					         
    					    FileWriter writer = null;        					         
    					        try
    					        {
    					            reader = new BufferedReader(new FileReader(file));
    					             
    					            //Reading all the lines of input text file into oldContent
    					             
    					            String lines = reader.readLine();
    					             
    					            while (lines != null) 
    					            {
    					                oldContent = oldContent + lines + System.lineSeparator();
    					                 
    					                lines = reader.readLine();
    					            }
					            		double doubletotFeeAmount = Double.parseDouble(totFeeAmount);
					            		double doubletotpaidAmount = Double.parseDouble(totpaidAmount);
    					            	if(doubletotpaidAmount != doubletotFeeAmount)
    					            	{

    					            	double stillToPay = doubletotFeeAmount-doubletotpaidAmount;
    					            	System.out.println("CUSTOMER 's INVOICE");
    					            	System.out.println(person.getCustomer());
    					            	System.out.println("The customer still has to pay : R" + stillToPay );
    					            	}
    					            
    					        }
    					        catch (IOException e)
    					        {
    					            e.printStackTrace();
    					        }
    					        finally
    					        {
    					            try
    					            {
    					                //Closing the resources
    					                 
    					                reader.close();
    					                 
    					               // writer.close();
    					            } 
    					            catch (IOException e) 
    					            {
    					                e.printStackTrace();
    					            }
    					        }
    					}       				
    				}
    			if(flag) 
    			{
    				System.out.println("");
    	          
    			} 
    			else 
    			{
    				System.out.println("Project :  '" + proNumber + "' not found in a file !!");
    			}
    		}
    		catch(FileNotFoundException e)
    		{
    			e.printStackTrace();	
    		}
			catch(IOException e)
			{
			e.printStackTrace();	
			}    	
    }
    
    /**
     * Finalizing a project
     * @param person The person object to get customer details
     */
    
    private static void  finalizeProject(Person person)
    {
        	System.out.println("\nEnter project number to finalize (eg :'Project1' : ");
        	String proNumber = scanner.next();
        	boolean flag = false;
        	int count = 0;
        	String pname;
        	String btype;
        	String paddress;
        	String erf;
        	String totFee;
        	String totpaid;
        	String dline;
        	String pstatus;
        	try
        		{
        			scanner = new Scanner(file)	;
        			while(scanner.hasNextLine()) 
        				{
        					String line = scanner.nextLine();
        					if(line.contains(proNumber)) 
        					{
        						flag=true;
        						System.out.println(line); 
        						btype = scanner.nextLine();
        						paddress = scanner.nextLine();
        						erf = scanner.nextLine();
        						totFee = scanner.nextLine();
        						totpaid = scanner.nextLine();
        						dline = scanner.nextLine();
        						pstatus = scanner.nextLine();
        						String pstatus1 = scanner.next();
        						String pstatus2 = scanner.next();
        						String pstatus3 = scanner.next();
        						String pstatus4 = scanner.next();
        						String old_pstatus = pstatus1 + " " + pstatus2 + " " + pstatus3 + " " + pstatus4; 						
        				        String oldContent = "";
        					    BufferedReader reader = null;        					         
        					    FileWriter writer = null;        					         
        					        try
        					        {
        					            reader = new BufferedReader(new FileReader(file));
        					             
        					            //Reading all the lines of input text file into oldContent
        					             
        					            String lines = reader.readLine();
        					             
        					            while (lines != null) 
        					            {
        					                oldContent = oldContent + lines + System.lineSeparator();
        					                 
        					                lines = reader.readLine();
        					            }
        					             
        					            //Replacing oldString with newString in the oldContent
        					             
        					            String newContent = oldContent.replaceAll(old_pstatus,pstatus1+ " is finalised");
        					             
        					            //Rewriting the input text file with newContent
        					             
        					            writer = new FileWriter(file);
        					             
        					            writer.write(newContent);
        					            System.out.println(pstatus1 + " has now been marked as Finalised !!");
        					            
        					            
        					        }
        					        catch (IOException e)
        					        {
        					            e.printStackTrace();
        					        }
        					        finally
        					        {
        					            try
        					            {
        					                //Closing the resources
        					                 
        					                reader.close();
        					                 
        					                writer.close();
        					            } 
        					            catch (IOException e) 
        					            {
        					                e.printStackTrace();
        					            }
        					        }
        					}       				
        				}
        			if(flag) 
        			{
        				System.out.println("");
        	          
        			} 
        			else 
        			{
        				System.out.println("Project :  '" + proNumber + "' not found in a file !!");
        			}
        		}
        		catch(FileNotFoundException e)
        		{
        			e.printStackTrace();	
        		}
    			catch(IOException e)
    			{
    			e.printStackTrace();	
    			} 
        	generatingInvoice(proNumber,person);
    }
    
    /**
     * Creating a new File and writing new project details to it
     * @param poised passing poised object as parameter
     */
    private static void  writtingProjectDataToFile(Poised poised)
    { 
    	 
        try 
        {
        	FileWriter fileWriter = new FileWriter(file,true);
        	formatter = new Formatter(fileWriter);
        	String stat = poised.getProject().getProjectNumber() + projectStatus;
        	formatter.format("%s%s%s",poised.getProject(),stat,"\r\n");
        	
        }
        catch(FileNotFoundException e)
        {
        	e.printStackTrace();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
        finally {
        	formatter.flush();
        	formatter.close();
        }
        System.out.println("\n\nProject added to the text file !!\n");
    }
    
    /**
     * Creating a project  method for the user to add a new project
     */
    public static Project createProjectObject() 
    {
        // Getting project input data from the user
        System.out.print("Enter the project name : ");
        String projectName = scanner.next();
        System.out.print("What type of building is being designed ? \n(house/apartment block/store etc): ");
        buildingType = scanner.next();
        System.out.print("What is the physical address for the project? : ");
        String physicalAddress = scanner.next();
        physicalAddress += scanner.nextLine();
        System.out.print("What is the ErfNo : ");
        String erfNo = scanner.next();
        System.out.print("What is the total fee being charged for the project? (Do not input currency symbol !!) : ");
        String projectTotalFee = "";
        String totalPaid = "";
        try 
        {
            projectTotalFee = scanner.next();
            boolean b = TestingUserInput.isNumeric(projectTotalFee );
            if(b)
            { 
            }
            else
            {   
            /** If what the user has typed as first number is not a valid number,
              * ask user to enter first number again until the input is a valid number
            */
                while(!b)
                {
                //Asking user to enter first number again
                    System.out.print("Please enter the total fee being charged for the project again? :  ");
                    projectTotalFee = scanner.next();
                    // Testing again if input is a valid number
                    b = TestingUserInput.isNumeric( projectTotalFee);
                }
            }
            System.out.print("What is the total amount paid to date?(Do not input currency symbol !!) : ");
            totalPaid = scanner.next();
            boolean b1 = TestingUserInput.isNumeric(totalPaid);
            if(b1)
            {
            }
            else 
            {
        	
            /** If what the user has typed as second number is not a valid number,
             * ask user to enter second number again until the input is a valid number
           */           
                while(!b1)
                {
                    System.out.print("Please enter the total fee being charged for the project again? : ");
                    totalPaid = scanner.next();
                    // Testing again if input is a valid number
                    b1 = TestingUserInput.isNumeric(totalPaid);
                }
             }	
        }
        catch(NumberFormatException e)
        {
        	e.printStackTrace();
        }
        System.out.print("What is the deadline for the project (dd/MM/yyyy) : ");
        String projectDeadline = scanner.next();
        projectDeadline += scanner.nextLine();
        String dueDate="";
        
        // Testing to see if the user has entered a valid date in valid format
        boolean valid = TestingUserInput.isValidFormat("dd/MM/yyyy", projectDeadline, Locale.ENGLISH);
        if(valid)
        {
        	 dueDate = projectDeadline;
        }
        else
        {   
        	/**
        	 * If the user has entered an invalid date or date in invalid format
        	 * Ask the to enter date again until it is correct format
        	 */
            while(!valid)
            {
                  System.out.println("Invalid date format,Enter the date(dd/mm/YYYY)");
                  projectDeadline = scanner.next();
                   valid = TestingUserInput.isValidFormat("dd/MM/yyyy", projectDeadline, Locale.ENGLISH);
                            if(valid)
                              {
                            	dueDate = projectDeadline;
                              break;
                              }
            }
        }
        Project project1 = createProjectObject(projectName,buildingType,physicalAddress,erfNo,projectTotalFee,totalPaid,dueDate);  
        return project1;
    }
    
    /**
     * updateProject method for the user to update a specific project
     */
    public static void updateProject() 
    {
        // Asking user to state whether they need to change the due date of the project
        System.out.print("Do you want to update the due date of the project ?(yes/no)");
        String updateDueDate = scanner.next();
        if(updateDueDate.equalsIgnoreCase("yes") )
        {
        // Asking user to change the due date of the project
            System.out.print("Enter the new due date of the project : ");
            String newDueDate = scanner.next();
            newDueDate += scanner.nextLine();
        //Updating the due date of the project in Project class
            project.setProjectDeadlineDate(newDueDate);
        }
        	else if(updateDueDate.equalsIgnoreCase("no") )
        	{
        	}
        	else 
        	{
                while(!updateDueDate.equalsIgnoreCase("yes") || !updateDueDate.equalsIgnoreCase("No"))
                {
                	System.out.print("'" + updateDueDate + "' is invalid answer,Do you want to update the due date of the project ?(yes/no)");
                	updateDueDate = scanner.nextLine();
                	if(updateDueDate.equalsIgnoreCase("yes") )
                	{
                		// Asking user to change the due date of the project
                		System.out.print("Enter the new due date of the project : ");
                		String newDueDate = scanner.next();
                		newDueDate += scanner.nextLine();
                		//Updating the due date of the project in Project class
                		project.setProjectDeadlineDate(newDueDate);
                		break;
                	}
                	else if(updateDueDate.equalsIgnoreCase("no") )
                	{
                		break;
                	}
                	else 
                	{
                    	System.out.print("'" + updateDueDate + "' is invalid answer,Do you want to update the due date of the project ?(yes/no)");
                    	updateDueDate = scanner.nextLine();
                    	if(updateDueDate.equalsIgnoreCase("yes") )
                    	{
                    		// Asking user to change the due date of the project
                    		System.out.print("Enter the new due date of the project : ");
                    		String newDueDate = scanner.next();
                    		newDueDate += scanner.nextLine();
                    		//Updating the due date of the project in Project class
                    		project.setProjectDeadlineDate(newDueDate);
                    		break;
                    	}
                    	else if(updateDueDate.equalsIgnoreCase("no") )
                    	{
                    		break;
                    	}
                	}
                 }
               
            }
        
        System.out.print("Do you want to update the total amount of the fee paid to date?(yes/no) : ");
        String updateAmountPaid = scanner.next();
        if(updateAmountPaid.equalsIgnoreCase("yes"))
        {       
           // Asking user to change the new total amount of the fee paid to date for the project
           System.out.print("Enter the new total amount of the fee paid to date : ");
           String totalPaidToDate = scanner.next();
           try 
           {
                boolean b2 = TestingUserInput.isNumeric(totalPaidToDate);
                if(b2)
                {
                     
                }
                else 
                {
           	
               /** If what the user has typed as second number is not a valid number,
                * ask user to enter second number again until the input is a valid number
              */           
                    while(b2 != true)
                    {
                         System.out.print("Please enter the new total amount of the fee paid to date again : ");
                         totalPaidToDate = scanner.next();
                         // Testing again if input is a valid number
                        b2 = TestingUserInput.isNumeric(totalPaidToDate);
                    }
                }	
           }
           catch(NumberFormatException e)
           {
           	e.printStackTrace();
           }
           //Updating the new total amount of the fee paid to date in Project class
           project.setTotalAmountPaidToDate(totalPaidToDate); 
        }
        	else if(updateAmountPaid.equalsIgnoreCase("no"))
        	{
        		
        	}
        	else
        	{
                while(!updateAmountPaid.equalsIgnoreCase("yes") || !updateAmountPaid.equalsIgnoreCase("No"))
                {	
                    System.out.print("'" + updateAmountPaid + "'is invalid answer,Do you want to update the total amount of the fee paid to date?(yes/no) : ");
                    updateAmountPaid = scanner.next();
                	if(updateAmountPaid.equalsIgnoreCase("yes"))
            		{
                		// Asking user to change the new total amount of the fee paid to date for the project
                        System.out.print("Enter the new total amount of the fee paid to date : ");
                        String totalPaidToDate = scanner.next();
                        try 
                        {
                             boolean b2 = TestingUserInput.isNumeric(totalPaidToDate);
                             if(b2)
                             {
                                  
                             }
                             else 
                             {
                        	
                            /** If what the user has typed as second number is not a valid number,
                             * ask user to enter second number again until the input is a valid number
                           */           
                                 while(b2 != true)
                                 {
                                      System.out.print("Please enter the new total amount of the fee paid to date again : ");
                                      totalPaidToDate = scanner.next();
                                      // Testing again if input is a valid number
                                     b2 = TestingUserInput.isNumeric(totalPaidToDate);
                                 }
                             }	
                        }
                        catch(NumberFormatException e)
                        {
                        	e.printStackTrace();
                        }
                        //Updating the new total amount of the fee paid to date in Project class
                        project.setTotalAmountPaidToDate(totalPaidToDate); 
                        break;
            		}
                	else if(updateAmountPaid.equalsIgnoreCase("no"))
                	{
                		break;
                	}
                	else
                	{
                        System.out.print("'" + updateAmountPaid + "'is invalid answer,Do you want to update the total amount of the fee paid to date?(yes/no) : ");
                        updateAmountPaid = scanner.next();
                    	if(updateAmountPaid.equalsIgnoreCase("yes"))
                		{
                    		// Asking user to change the new total amount of the fee paid to date for the project
                            System.out.print("Enter the new total amount of the fee paid to date : ");
                            String totalPaidToDate = scanner.next();
                            try 
                            {
                                 boolean b2 = TestingUserInput.isNumeric(totalPaidToDate);
                                 if(b2)
                                 {
                                      
                                 }
                                 else 
                                 {
                            	
                                /** If what the user has typed as second number is not a valid number,
                                 * ask user to enter second number again until the input is a valid number
                               */           
                                     while(b2 != true)
                                     {
                                          System.out.print("Please enter the new total amount of the fee paid to date again : ");
                                          totalPaidToDate = scanner.next();
                                          // Testing again if input is a valid number
                                         b2 = TestingUserInput.isNumeric(totalPaidToDate);
                                     }
                                 }	
                            }
                            catch(NumberFormatException e)
                            {
                            	e.printStackTrace();
                            }
                            //Updating the new total amount of the fee paid to date in Project class
                            project.setTotalAmountPaidToDate(totalPaidToDate); 
                            break;
                		}
                    	else if(updateAmountPaid.equalsIgnoreCase("no"))
                    	{
                    		break;
                    	}	
                	}
                	
                }
        	}
        System.out.print("Do you want to update the contractor 's contact details details?(yes/no) : ");
        String updateContractorDetails = scanner.next();
        
        if(updateContractorDetails.equalsIgnoreCase("yes"))
        { 
            updateContractorDetails(person.getContractor());  
        }
        else if(updateContractorDetails.equalsIgnoreCase("No"))
        	{
         
        	}
        else 
        	{
                while(!updateContractorDetails.equalsIgnoreCase("yes") || !updateContractorDetails.equalsIgnoreCase("No"))
                {
                	System.out.print("'" + updateContractorDetails + "' is invalid input,Do you want to update the contractor 's contact details details?(yes/no) : ");
                	updateContractorDetails = scanner.next();
                	if(updateContractorDetails.equalsIgnoreCase("yes"))
                		{ 
                			updateContractorDetails(person.getContractor());
                			break;
                		}
                    else if(updateContractorDetails.equalsIgnoreCase("no"))
                    {
                      break;      	
                    }
                    else 
                    {
                    	System.out.print("'" + updateContractorDetails + "' is invalid input,Do you want to update the contractor 's contact details details?(yes/no) : ");
                    	updateContractorDetails = scanner.next();
                    	if(updateContractorDetails.equalsIgnoreCase("yes"))
                    		{ 
                    			updateContractorDetails(person.getContractor());
                    			break;
                    		}
                        else if(updateContractorDetails.equalsIgnoreCase("no"))
                        {
                          break;      	
                        }                    	
                    }
                	
                }
        	}
        
    }
    
    /**
     * search for a project method for the user to search for a project the want to view
     */
    public static void searchProject()
    {
        	System.out.println("\nEnter project number to search (eg :'Project1' : ");
        	String proNumber = scanner.next();
        	boolean flag = false;
        	int count = 0;
        	String pname;
        	String btype;
        	String paddress;
        	String erf;
        	String totFee;
        	String totpaid;
        	String dline;
        	String pstatus;
        	try
        		{
        			scanner = new Scanner(file)	;
        			while(scanner.hasNextLine()) 
        				{
        					String line = scanner.nextLine();
        					if(line.indexOf(proNumber)!= -1) 
        					{
        						flag = true;
        						System.out.println(line); 
        						pname = scanner.nextLine();
        						btype = scanner.nextLine();
        						paddress = scanner.nextLine();
        						erf = scanner.nextLine();
        						totFee = scanner.nextLine();
        						totpaid = scanner.nextLine();
        						dline = scanner.nextLine();
        						pstatus = scanner.nextLine();
        		        	 
        						System.out.println(line);
        						System.out.println(btype);
        						System.out.println(paddress);
        						System.out.println(erf);
        						System.out.println(totFee);
        						System.out.println(totpaid);
        						System.out.println(dline);
        						System.out.println(pstatus);
        						break;
        					}       				
        				}
        			if(flag) 
        			{
        				System.out.println("");
        	          
        			} 
        			else 
        			{
        				System.out.println("Project :  '" + proNumber + "' not found in a file !!");
        			}
        		}
        		catch(FileNotFoundException e)
        		{
        			e.printStackTrace();	
        		}
        	
    }
    
    /**
     * viewAllProjects method for the user to view all projects
     */
    public static void viewAllProjects() 
    {
    	try {
    		scanner = new Scanner(file);
    		while(scanner.hasNextLine())
    		{
    			System.out.println(scanner.nextLine());
    		}
    	}
    	catch(FileNotFoundException e) 
    	{
    		e.printStackTrace();
    	}
    	
    }
    
    /**
     * viewAllProjects method for the user to view all projects
     */
    public static void viewAllProjectsStilltobeCompleted() 
    {
    	try {
    		scanner = new Scanner(file);
    		while(scanner.hasNextLine())
    		{
    			String ProjectNo=scanner.nextLine();
    			if(ProjectNo.contains("is not finalised"))
    			{
    				System.out.println(ProjectNo);	
    			}
    			
    		}
    	}
    	catch(FileNotFoundException e) 
    	{
    		e.printStackTrace();
    	}
    	
    }
    
    /**
     * viewAllProjects method for the user to view all projects
     */
    public static void viewAllProjectspastdue() 
    {
    	try {
    		scanner = new Scanner(file);
    		while(scanner.hasNextLine())
    		{
    			String ProjectNo=scanner.nextLine();
    			if(ProjectNo.contains("Project1 is not finalised"))
    			{
    				System.out.println(ProjectNo);	
    			}
    			
    		}
    	}
    	catch(FileNotFoundException e) 
    	{
    		e.printStackTrace();
    	}
    	
    }
    
    /**
     * makeChoice method for the user to choose what they want to do
     */
    public static void makeChoice() 
    {
        System.out.println("\nWould you like add new project?  To search for a specific project?  To view all existing projects?  To update a project? ");
        System.out.println("Select option below  : \n 'ap' for : Adding new Project\n 'sc' for : Searching for a project\n 'va' for : Viewing all projects \n 'up' for : Updating  a project\n 'fp' for : Finalizing a project\n 'lc' for : List of project still to be completed\n 'lp' for : List of project past due date");
        choice = scanner.next();

        // If the user choose to search for a specific project,call search method
        if(choice.equalsIgnoreCase("sc")) 
        {
        	searchProject();
        	
        }
        
     // If the user choose to view all projects,call viewAllProjects method
        else if(choice.equalsIgnoreCase("va")) 
        {
        	viewAllProjects();      
        }
        
     // If the user choose to update a specific project,call updateProject method
        else if(choice.equalsIgnoreCase("up")) 
        {
        	updateProject();
        	
        }
        
     // If the user choose to add project,call addProject method
        else if(choice.equalsIgnoreCase("ap")) 
        {
            person = createPersonObject();
            project =createProjectObject() ;
            poised = new Poised(project,person); 
            writtingProjectDataToFile(poised);
            makeChoice();   
        }
        
     // If the user choose to finalize project,call finalize Project method
        else if (choice.equalsIgnoreCase("fp"))
        {
        	// Getting a person object to extract customer 's details
            person = createPersonObject();
        	finalizeProject(person);
        }
        
        else if(choice.equalsIgnoreCase("lc")) 
        {
        	viewAllProjectsStilltobeCompleted();
        	
        }
        
        else if(choice.equalsIgnoreCase("lp")) 
        {
        	viewAllProjectspastdue();
        	
        }
        
     // If the user entered invalid choice,ask them to re enter choice
        else
        {
        	System.out.println(choice + " is an invalid choice !!\n");
        	makeChoice();
        }
    }
   
    /**
     * main method
     * @param args[]
     */
    public static void main(String [] args)
    {
    	makeChoice(); 
    }
}
