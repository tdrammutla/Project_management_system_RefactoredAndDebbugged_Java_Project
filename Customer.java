/*
 *Project Customer Class
 * @author Tebogo Rammutla
 */

/**
  * Customer Class
  */
public class Customer
{
    //Properties of Customer class
    private String name;
    private String surname;
    private String telephoneNumber;
    private String emailAddress;
    private String physicalAddress;
    
    /**
     * Constructor of Customer Class
     * @param name the customer name to set
     * @param surname the customer surname to set
     * @param telephoneNumber the customer telephoneNumber to set
     * @param emailAddress the customer email address to set
     * @param physicalAddress the customer physical address to set
     */
    public Customer(String name,String surname,String telephoneNumber,String emailAddress,String physicalAddress )
    {
    	this.name = name;
    	this.surname = surname;
    	this.telephoneNumber = telephoneNumber;
    	this.emailAddress = emailAddress;
    	this.physicalAddress = physicalAddress;   
    
    }
    
    /**
     * toString
     * @return customer string object
     */ 
    public String toString()
    {
        String customer;
                customer= "\nCustomer name : " + name
                + "\nCustomer surname : " + surname
                + "\nCustomer telephone number : " + telephoneNumber
                + "\nCustomer email_address : " + emailAddress
                + "\nCustomer physical_address : " + physicalAddress ;
        
        return customer;
    }
    
    /**
     * getSurname
     * @return customer surname
     */ 
    public String getSurname()
    {
        return this.surname;
    }
    
}
